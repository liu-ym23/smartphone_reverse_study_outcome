package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.export.entity.chatter.OpenChatter;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.log.Log;
import java.util.Locale;

/* JADX INFO: loaded from: classes35.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final okb.a f416699a = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f416700a = null;

        static {
            int[] r100 = new int[ChatterNameDisplayRule.values().length];
            f416700a = r100;
            r100[ChatterNameDisplayRule.ALIAS_NAME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f416700a[ChatterNameDisplayRule.NICKNAME_NAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f416700a[ChatterNameDisplayRule.ALIAS_NICKNAME_NAME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f416700a[ChatterNameDisplayRule.NICKNAME_ALIAS_NAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f416700a[ChatterNameDisplayRule.NICKNAME_WITH_ALIAS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        f416699a = ImSdkProxy.b();
    }

    public static char a(ChatChatter r100, Locale r101) {
        if (r100 != null) goto L5;
        return '#';
    L5:
        String r102 = r100.getName();
        String r103 = r100.getLocalizedName();
        String r104 = r100.getNamePy();
        if (TextUtils.isEmpty(r103) == false) goto L11;
        if (TextUtils.isEmpty(r102) == false) goto L11;
        return '#';
    L11:
        if (TextUtils.isEmpty(r103) == false) goto L13;
        char r105 = r102.charAt(0);
    L15:
        if (Locale.CHINESE.getLanguage().equals(r101.getLanguage()) == false) goto L20;
        if (TextUtils.isEmpty(r104) == true) goto L20;
        r105 = r104.charAt(0);
    L20:
        if ('A' > r105) goto L25;
        if (r105 > 'Z') goto L25;
    L28:
        boolean r106 = true;
    L30:
        if (r106 == true) goto L32;
        return '#';
    L32:
        return String.valueOf(r105).toUpperCase().charAt(0);
    L25:
        if ('a' <= r105) goto L27;
    L29:
        r106 = false;
        goto L30
    L27:
        if (r105 > 'z') goto L29;
    L13:
        r105 = r103.charAt(0);
        goto L15
    }

    public static String c(String r100, String r101) {
        okb.a r102 = f416699a;
        Locale r103 = r102.getCacheLanguageSetting();
        if (r103 != null) goto L7;
        Log.e("ChatterNameUtil", "getDisplayName failed: locale is null");
        return r102.c().getLanguage();
    L7:
        if (Locale.ENGLISH.getLanguage().equals(r103.getLanguage()) == true) goto L9;
    L11:
        return r100;
    L9:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return r101;
    }

    public static String b(OpenChatter r100, ChatterNameDisplayRule r110, boolean r111) {
        String r101 = "";
        if (r100 != null) goto L6;
        return "";
    L6:
        if ((r100 instanceof ChatChatter) == false) goto L12;
        ChatChatter r102 = (ChatChatter) r100;
        if (r102.isOncallDuty() == true) goto L10;
        String r103 = r102.getNickName();
    L13:
        String r104 = r103;
        String r105 = r100.getAlias();
        String r106 = r100.getName();
        String r107 = r100.getLocalizedName();
        String r108 = r100.getEnName();
        if (r111 == false) goto L17;
        r101 = r100.getNameWithAnotherName();
    L17:
        return d(r106, r108, r107, r104, r105, r101, r110);
    L10:
        return r102.getName();
    L12:
        r103 = null;
        goto L13
    }

    public static String d(String r100, String r101, String r102, String r103, String r104, String r105, ChatterNameDisplayRule r106) {
        int r107 = a.f416700a[r106.ordinal()];
        if (r107 == 1) goto L40;
        if (r107 == 2) goto L37;
        if (r107 == 3) goto L31;
        if (r107 == 4) goto L25;
        if (r107 != 5) goto L43;
        if (com.larksuite.framework.utils.f0.a(r103) == true) goto L22;
        StringBuilder r108 = new StringBuilder();
        r108.append(r103);
        if (com.larksuite.framework.utils.f0.a(r104) == true) goto L18;
        String r109 = String.format("(%s)", new Object[]{r104});
    L19:
        r108.append(r109);
        return r108.toString();
    L18:
        r109 = "";
        goto L19
    L22:
        if (com.larksuite.framework.utils.f0.a(r104) == true) goto L43;
        return r104;
    L43:
        if (com.larksuite.framework.utils.f0.a(r105) == true) goto L46;
        return r105;
    L46:
        if (TextUtils.isEmpty(r102) == true) goto L49;
        r100 = r102;
    L49:
        return c(r100, r101);
    L25:
        if (com.larksuite.framework.utils.f0.a(r103) == true) goto L28;
        return r103;
    L28:
        if (com.larksuite.framework.utils.f0.a(r104) == true) goto L43;
        return r104;
    L31:
        if (com.larksuite.framework.utils.f0.a(r104) == true) goto L34;
        return r104;
    L34:
        if (com.larksuite.framework.utils.f0.a(r103) == true) goto L43;
        return r103;
    L37:
        if (com.larksuite.framework.utils.f0.a(r103) == true) goto L43;
        return r103;
    L40:
        if (com.larksuite.framework.utils.f0.a(r104) == true) goto L43;
        return r104;
    }
}
