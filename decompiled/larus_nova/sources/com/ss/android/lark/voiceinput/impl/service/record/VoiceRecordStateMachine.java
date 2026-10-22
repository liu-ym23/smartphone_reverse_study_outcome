package com.ss.android.lark.voiceinput.impl.service.record;

import abc.c;
import com.ss.android.lark.voiceinput.api.data.model.record.VoiceRecordState;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.b1;

/* JADX INFO: loaded from: classes38.dex */
public final class VoiceRecordStateMachine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jbc.a<c> f445123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b1 f445124b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f445125a = null;

        static {
            int[] r100 = new int[VoiceRecordState.values().length];
            r100[VoiceRecordState.Idle.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[VoiceRecordState.Preparing.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[VoiceRecordState.Prepared.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[VoiceRecordState.Recording.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[VoiceRecordState.Stopped.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[VoiceRecordState.Canceled.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[VoiceRecordState.Failed.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[VoiceRecordState.Destroy.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f445125a = r100;
        }
    }

    public final VoiceRecordState c() {
        return ((c) this.f445124b.getValue()).f2527b;
    }

    public VoiceRecordStateMachine() {
        jbc.a<c> r100 = new jbc.a(new c(0), new VoiceRecordStateMachine$stateMachine$1(this));
        this.f445123a = r100;
        this.f445124b = r100.f498066c;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final boolean a(VoiceRecordState r100) {
        Intrinsics.checkNotNullParameter(r100, "newState");
        jbc.a<c> r101 = this.f445123a;
        Object r102 = new c(((c) this.f445124b.getValue()).f2526a, r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "nextValue");
        return r101.f498064a.invoke((T) r101.f498065b.getValue(), (T) r102).booleanValue();
    }

    public static void b(VoiceRecordStateMachine r100, VoiceRecordState r101) {
        String r102 = ((c) r100.f445124b.getValue()).f2526a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "newState");
        jbc.a<c> r103 = r100.f445123a;
        c r104 = new c(r102, r101);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "nextValue");
        r103.f498065b.setValue(r104);
    }

    public static boolean d(VoiceRecordState r100, VoiceRecordState... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L14;
        if (r101[r103] != r100) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L9;
        r103 = r103 + 1;
        goto L3
    L9:
        return true;
    L7:
        r104 = false;
        goto L8
    L14:
        return false;
    }

    public static boolean f(VoiceRecordStateMachine r100, VoiceRecordState r101) {
        return r100.e(r101, ((c) r100.f445124b.getValue()).f2526a);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final boolean e(VoiceRecordState r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "newState");
        jbc.a<c> r102 = this.f445123a;
        Object r103 = new c(r101, r100);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "nextValue");
        Intrinsics.checkNotNullParameter(r103, "nextValue");
        if (r102.f498064a.invoke((T) r102.f498065b.getValue(), (T) r103).booleanValue() == false) goto L5;
        r102.f498065b.setValue(r103);
        return true;
    L5:
        return false;
    }
}
