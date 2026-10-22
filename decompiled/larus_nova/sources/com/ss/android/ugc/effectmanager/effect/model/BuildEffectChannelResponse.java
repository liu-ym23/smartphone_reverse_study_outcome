package com.ss.android.ugc.effectmanager.effect.model;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.common.utils.EffectUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class BuildEffectChannelResponse {
    private String mFileDirectory;
    private boolean mIsCache;
    private String mPanel;

    public EffectChannelResponse buildChannelResponse(EffectChannelModel r100) {
        HashMap r101 = new HashMap();
        HashMap r102 = new HashMap();
        Iterator<Effect> r103 = r100.getEffects().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Effect r104 = r103.next();
        r101.put(r104.getEffectId(), r104);
        goto L4
    L6:
        Iterator<Effect> r105 = r100.getCollection().iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        Effect r106 = r105.next();
        r102.put(r106.getEffectId(), r106);
        goto L8
    L10:
        EffectChannelResponse r107 = new EffectChannelResponse();
        r107.setPanel(this.mPanel);
        r107.setVersion(r100.getVersion());
        r107.setAllCategoryEffects(r100.getEffects());
        r107.setCollections(r100.getCollection());
        r107.setUrlPrefix(r100.getUrlPrefix());
        r107.setCategoryResponseList(initCategory(r100, r101));
        getChildEffect(r100.getEffects(), r102);
        r107.setPanelModel(r100.getPanel());
        r107.setFrontEffect(getEffect(r100.getFront_effect_id(), r101));
        r107.setRearEffect(getEffect(r100.getRear_effect_id(), r101));
        if (this.mIsCache == true) goto L13;
        EffectUtils.setEffectField(this.mFileDirectory, this.mPanel, r100.getEffects());
        EffectUtils.setEffectField(this.mFileDirectory, this.mPanel, r100.getCollection());
    L13:
        return r107;
    }

    private List<Effect> getCategoryAllEffects(EffectCategoryModel r100, Map<String, Effect> r101) {
        ArrayList r102 = new ArrayList();
        Iterator<String> r103 = r100.getEffects().iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Effect r104 = r101.get(r103.next());
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L8:
        return r102;
    }

    private void getChildEffect(List<Effect> r100, Map<String, Effect> r101) {
        Iterator<Effect> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        Effect r103 = r102.next();
        if (r103.getEffectType() != 1) goto L4;
        ArrayList r104 = new ArrayList();
        List<String> r105 = r103.getChildren();
        if (r105 == null) goto L15;
        Iterator<String> r106 = r105.iterator();
    L11:
        if (r106.hasNext() == false) goto L15;
        Effect r107 = r101.get(r106.next());
        if (r107 == null) goto L11;
        r104.add(r107);
    L15:
        r103.setChildEffects(r104);
        goto L4
    }

    private Effect getEffect(String r100, Map<String, Effect> r101) {
        return r101.get(r100);
    }

    private List<EffectCategoryResponse> initCategory(EffectChannelModel r100, Map<String, Effect> r101) {
        ArrayList r102 = new ArrayList();
        if (r100.getCategory().isEmpty() == true) goto L18;
        Iterator<EffectCategoryModel> r103 = r100.getCategory().iterator();
    L6:
        if (r103.hasNext() == false) goto L18;
        EffectCategoryModel r104 = r103.next();
        EffectCategoryResponse r105 = new EffectCategoryResponse();
        r105.setId(r104.getId());
        r105.setName(r104.getName());
        r105.setKey(r104.getKey());
        if (r104.getIcon() == null) goto L13;
        if (r104.getIcon().getUrl_list().isEmpty() == true) goto L13;
        r105.setIcon_normal_url((String) ListProtector.get(r104.getIcon().getUrl_list(), 0));
    L13:
        if (r104.getIcon_selected() == null) goto L17;
        if (r104.getIcon_selected().getUrl_list().isEmpty() == true) goto L17;
        r105.setIcon_selected_url((String) ListProtector.get(r104.getIcon_selected().getUrl_list(), 0));
    L17:
        r105.setTotalEffects(getCategoryAllEffects(r104, r101));
        r105.setTags(r104.getTags());
        r105.setTagsUpdateTime(r104.getTagsUpdateTime());
        r105.setCollectionEffect(r100.getCollection());
        r105.setExtra(r104.getExtra());
        r105.setDefault(r104.isDefault());
        r102.add(r105);
    L18:
        return r102;
    }

    public BuildEffectChannelResponse(String r100, String r101, boolean r102) {
        this.mPanel = r100;
        this.mFileDirectory = r101;
        this.mIsCache = r102;
    }
}
