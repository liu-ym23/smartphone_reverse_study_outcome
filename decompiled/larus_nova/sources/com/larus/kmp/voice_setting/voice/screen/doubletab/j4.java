package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.kmp.voice_setting.platform.VoiceStringKey;
import com.larus.kmp.voice_setting.voice.component.VoiceDropdownMenuItemKind;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Long> f354399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<VoiceStringKey, Unit> f354400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Unit> f354401c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f354402a = null;

        static {
            int[] r100 = new int[VoiceDropdownMenuItemKind.values().length];
            r100[VoiceDropdownMenuItemKind.EDIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[VoiceDropdownMenuItemKind.DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f354402a = r100;
        }
    }

    public static String a(com.larus.kmp.voice_setting.voice.component.v4 r100) {
        String r101 = r100.f352580a;
        String r102 = "";
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        if (StringsKt.isBlank(r101) == false) goto L16;
        String r103 = r100.f352589j.get("key_enter_method");
        if (r103 != null) goto L13;
        String r104 = r100.f352589j.get("enter_method");
        if (r104 == null) goto L15;
        r102 = r104;
    L15:
        return r102;
    L13:
        r102 = r103;
        goto L15
    L16:
        return r101;
    }

    public j4(g6 r100, Function1 r101, h6 r102) {
        Intrinsics.checkNotNullParameter(r100, "currentTimeMillis");
        Intrinsics.checkNotNullParameter(r101, "showToast");
        Intrinsics.checkNotNullParameter(r102, "logInfo");
        this.f354399a = r100;
        this.f354400b = r101;
        this.f354401c = r102;
    }
}
