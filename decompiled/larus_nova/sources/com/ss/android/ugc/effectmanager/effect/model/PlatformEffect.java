package com.ss.android.ugc.effectmanager.effect.model;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.common.model.UrlModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class PlatformEffect {
    String file_uri;
    String hint;
    String hint_uri;
    String icon_uri;
    String name;
    List<String> requirements;
    List<String> types;

    public PlatformEffect() {
    }

    public Effect toEffect(List<String> r100) {
        Effect r101 = new Effect();
        r101.setName(this.name);
        r101.setHint(this.hint);
        r101.setFileUrl(concatPrefixWithUri(r100, this.file_uri));
        r101.setTypes(this.types);
        r101.setHintIcon(concatPrefixWithUri(r100, this.hint_uri));
        r101.setIconUrl(concatPrefixWithUri(r100, this.icon_uri));
        r101.setRequirements(this.requirements);
        r101.setId(this.file_uri);
        return r101;
    }

    public UrlModel concatPrefixWithUri(List<String> r100, String r101) {
        UrlModel r102 = new UrlModel();
        r102.setUri(r101);
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L4:
        if (r104 >= r100.size()) goto L6;
        r103.add(((String) ListProtector.get(r100, r104)) + r101);
        r104 = r104 + 1;
        goto L4
    L6:
        r102.setUrlList(r103);
        return r102;
    }
}
