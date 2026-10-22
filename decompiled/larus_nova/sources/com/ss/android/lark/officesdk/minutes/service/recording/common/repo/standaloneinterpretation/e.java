package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAIInterpretationAecPolicy;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.h;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.j;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.l;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Boolean> f435132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Boolean, Unit> f435133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Boolean, Unit> f435134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Integer, Unit> f435135d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<j, String, Boolean> f435136e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f435137f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f435138g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f435139h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f435140i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f435141j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f435142k;

    public final boolean a(String r100) {
        if (this.f435137f == true) goto L5;
        return false;
    L5:
        String r101 = this.f435138g;
        if (r101 != null) goto L8;
        return false;
    L8:
        boolean r102 = this.f435142k;
        this.f435133b.invoke(Boolean.valueOf(r102));
        int r103 = l.f434781a;
        Intrinsics.checkNotNullParameter(r101, "targetLanguage");
        if (StringsKt.isBlank(r101) == false) goto L11;
        j r104 = null;
    L12:
        if (r104 != null) goto L14;
        return false;
    L14:
        boolean r105 = this.f435136e.invoke(r104, r100).booleanValue();
        if (r105 == false) goto L17;
        this.f435138g = null;
    L17:
        return r105;
    L11:
        r104 = new j(true, CollectionsKt.listOf(r101), r102, MmAIInterpretationAecPolicy.TRANSCRIPT_ONLY);
        goto L12
    }

    public final boolean b(boolean r100) {
        int r101 = 0;
        if (r100 == true) goto L5;
    L19:
        return false;
    L5:
        if (this.f435137f == false) goto L19;
        int r102 = h.f434768a;
        if (this.f435142k == false) goto L10;
    L13:
        boolean r103 = true;
    L14:
        if (r103 == true) goto L18;
        r101 = 100;
    L18:
        return c(r101);
    L10:
        if (this.f435140i == true) goto L13;
        r103 = false;
        goto L14
    }

    public final boolean c(int r100) {
        Integer r101 = this.f435141j;
        if (r101 != null) goto L6;
    L9:
        this.f435141j = Integer.valueOf(r100);
        this.f435135d.invoke(Integer.valueOf(r100));
        return true;
    L6:
        if (r101.intValue() != r100) goto L9;
        return false;
    }

    public final d d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "source");
        this.f435142k = this.f435132a.invoke().booleanValue();
        boolean r102 = true;
        if (r100 != null) goto L5;
    L7:
        r100 = null;
    L8:
        boolean r103 = false;
        if (r100 != null) goto L16;
        this.f435138g = null;
        this.f435139h = null;
        this.f435140i = false;
        boolean r104 = this.f435142k;
        this.f435133b.invoke(Boolean.valueOf(r104));
        if (this.f435137f == false) goto L15;
        int r105 = h.f434768a;
        r103 = c(100);
    L15:
        return new d(r104, r103, this.f435140i);
    L16:
        String r106 = this.f435139h;
        if (r106 != null) goto L19;
    L21:
        this.f435138g = r100;
        this.f435139h = r100;
        boolean r107 = this.f435142k;
        this.f435133b.invoke(Boolean.valueOf(r107));
        boolean r108 = a(r101);
        boolean r109 = b(true);
        if (r108 == true) goto L27;
        if (r109 == true) goto L27;
        r102 = false;
    L27:
        return new d(r107, r102, this.f435140i);
    L19:
        if (Intrinsics.areEqual(r106, r100) == true) goto L21;
        this.f435140i = false;
        goto L21
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Function0<Boolean> r100, Function1<? super Boolean, Unit> r101, Function1<? super Boolean, Unit> r102, Function1<? super Integer, Unit> r103, Function2<? super j, ? super String, Boolean> r104) {
        Intrinsics.checkNotNullParameter(r100, "currentPlaybackMutedProvider");
        Intrinsics.checkNotNullParameter(r101, "updatePlaybackMutedState");
        Intrinsics.checkNotNullParameter(r102, "setPlaybackDigitalMute");
        Intrinsics.checkNotNullParameter(r103, "setPlaybackVolume");
        Intrinsics.checkNotNullParameter(r104, "applyRtcAction");
        this.f435132a = r100;
        this.f435133b = r101;
        this.f435134c = r102;
        this.f435135d = r103;
        this.f435136e = r104;
        this.f435142k = r100.invoke().booleanValue();
    }
}
