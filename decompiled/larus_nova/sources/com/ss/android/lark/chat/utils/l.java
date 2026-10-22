package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.util.Comparator;
import java.util.Locale;

/* JADX INFO: loaded from: classes35.dex */
public final class l implements Comparator<Chatter> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Locale f416693a;

    public l() {
        this.f416693a = m.f416699a.getCacheLanguageSetting();
    }

    @Override // java.util.Comparator
    public final int compare(Chatter r100, Chatter r101) {
        Chatter r102 = r100;
        Chatter r103 = r101;
        if (r102.getLocalizedName() != null) goto L5;
        String r104 = r102.getName();
    L7:
        if (r103.getLocalizedName() != null) goto L9;
        String r105 = r103.getName();
    L11:
        if (Locale.CHINESE.getLanguage().equals(this.f416693a.getLanguage()) == false) goto L23;
        String r106 = r102.getNamePy();
        if (TextUtils.isEmpty(r106) == false) goto L15;
    L17:
        String r107 = r103.getNamePy();
        if (TextUtils.isEmpty(r107) == true) goto L23;
        if (r107.equals("#") == true) goto L23;
        r105 = r107;
        goto L23
    L15:
        if (r106.equals("#") == true) goto L17;
        r104 = r106;
    L23:
        if (r104.equalsIgnoreCase(r105) == false) goto L26;
        return r102.getId().compareTo(r103.getId());
    L26:
        return r104.toUpperCase().compareTo(r105.toUpperCase());
    L9:
        r105 = r103.getLocalizedName();
        goto L11
    L5:
        r104 = r102.getLocalizedName();
        goto L7
    }
}
