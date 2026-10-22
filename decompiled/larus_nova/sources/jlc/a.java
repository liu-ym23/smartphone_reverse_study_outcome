package jlc;

import bytekn.foundation.logger.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.EffectCategoryModel;
import com.ss.ugc.effectplatform.model.EffectCategoryResponse;
import com.ss.ugc.effectplatform.model.EffectChannelModel;
import com.ss.ugc.effectplatform.model.EffectChannelResponse;
import com.ss.ugc.effectplatform.model.UrlModel;
import com.ss.ugc.effectplatform.util.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f499607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f499608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f499609c;

    /* JADX INFO: renamed from: jlc.a$a, reason: collision with other inner class name */
    public static final class C6456a {
    }

    static {
    }

    public final EffectChannelResponse a(EffectChannelModel r210) {
        HashMap r100 = new HashMap();
        HashMap r101 = new HashMap();
        Iterator<Effect> r102 = r210.getEffect_list().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Effect r103 = r102.next();
        r100.put(r103.getEffect_id(), r103);
        goto L4
    L6:
        Iterator<Effect> r104 = r210.getCollection_list().iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        Effect r105 = r104.next();
        r101.put(r105.getEffect_id(), r105);
        goto L8
    L10:
        EffectChannelResponse r106 = new EffectChannelResponse(null, null, null, null, null, null, null, null, null, 511, null);
        r106.setPanel(this.f499607a);
        r106.setVersion(r210.getVersion());
        r106.setAll_category_effects(r210.getEffect_list());
        r106.setCollection_list(r210.getCollection_list());
        r106.setUrl_prefix(r210.getUrl_prefix());
        ArrayList r107 = new ArrayList();
        if ((!r210.getCategory_list().isEmpty()) == false) goto L52;
        Iterator<EffectCategoryModel> r108 = r210.getCategory_list().iterator();
    L14:
        if (r108.hasNext() == false) goto L52;
        EffectCategoryModel r109 = r108.next();
        String r211 = null;
        EffectCategoryResponse r110 = new EffectCategoryResponse(null, null, null, null, null, null, null, null, null, null, null, false, null, 8191, null);
        r110.setId(r109.getId());
        r110.setName(r109.getName());
        r110.setKey(r109.getKey());
        UrlModel r111 = r109.getIcon();
        if (r111 == null) goto L28;
        List<String> r112 = r111.getUrl_list();
        if (r112 == null) goto L28;
        if ((!r112.isEmpty()) != true) goto L28;
        UrlModel r113 = r109.getIcon();
        if (r113 == null) goto L26;
        List<String> r114 = r113.getUrl_list();
        if (r114 == null) goto L26;
        String r115 = (String) ListProtector.get(r114, 0);
    L27:
        r110.setIcon_normal_url(r115);
    L26:
        r115 = null;
    L28:
        UrlModel r116 = r109.getIcon_selected();
        if (r116 == null) goto L40;
        List<String> r117 = r116.getUrl_list();
        if (r117 == null) goto L40;
        if ((!r117.isEmpty()) != true) goto L40;
        UrlModel r118 = r109.getIcon_selected();
        if (r118 == null) goto L39;
        List<String> r119 = r118.getUrl_list();
        if (r119 == null) goto L39;
        r211 = (String) ListProtector.get(r119, 0);
    L39:
        r110.setIcon_selected_url(r211);
    L40:
        ArrayList r120 = new ArrayList();
        if (r109.getEffects() != null) goto L43;
        Logger.INSTANCE.d("BuildEffectChannelResponse", "categoryModel is null");
    L43:
        List<String> r121 = r109.getEffects();
        if (r121 == null) goto L51;
        Iterator<String> r122 = r121.iterator();
    L47:
        if (r122.hasNext() == false) goto L51;
        Effect r123 = (Effect) r100.get(r122.next());
        if (r123 == null) goto L47;
        r120.add(r123);
    L51:
        r110.setTotal_effects(r120);
        r110.setTags(r109.getTags());
        r110.setTags_update_time(r109.getTags_updated_at());
        r110.setCollection_effect(r210.getCollection_list());
        r110.setExtra(r109.getExtra());
        r110.set_default(r109.is_default());
        r107.add(r110);
    L52:
        r106.setCategory_responses(r107);
        Iterator<Effect> r124 = r210.getEffect_list().iterator();
    L54:
        if (r124.hasNext() == false) goto L68;
        Effect r125 = r124.next();
        if (r125.getEffect_type() != 1) goto L54;
        ArrayList r126 = new ArrayList();
        List<String> r127 = r125.getChildren();
        if (r127 != null) goto L61;
        r127 = new ArrayList();
    L61:
        Iterator<String> r128 = r127.iterator();
    L63:
        if (r128.hasNext() == false) goto L67;
        Effect r129 = (Effect) r101.get(r128.next());
        if (r129 == null) goto L63;
        r126.add(r129);
        goto L63
    L67:
        r125.setChild_effects(r126);
        goto L54
    L68:
        r106.setPanel_model(r210.getPanel_model());
        String r130 = r210.getFront_effect_id();
        Effect r131 = null;
        if (r130 == null) goto L71;
        Effect r132 = (Effect) r100.get(r130);
    L72:
        r106.setFront_effect(r132);
        String r133 = r210.getRear_effect_id();
        if (r133 == null) goto L75;
        r131 = (Effect) r100.get(r133);
    L75:
        r106.setRear_effect(r131);
        if (this.f499609c == true) goto L78;
        h r134 = h.f458037a;
        String r135 = this.f499608b;
        String r136 = this.f499607a;
        List<Effect> r137 = r210.getEffect_list();
        r134.getClass();
        h.d(r135, r136, r137);
        h.d(this.f499608b, this.f499607a, r210.getCollection_list());
    L78:
        return r106;
    L71:
        r132 = null;
        goto L72
    }

    public a(String r100, String r101, boolean r102) {
        this.f499607a = r100;
        this.f499608b = r101;
        this.f499609c = r102;
    }
}
