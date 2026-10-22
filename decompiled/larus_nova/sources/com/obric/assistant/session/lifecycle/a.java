package com.obric.assistant.session.lifecycle;

import bga.i;
import bga.j;
import com.obric.assistant.session.model.ISessionMaintaining;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f391620a;

    public a() {
    }

    public final String c() {
        return this.f391620a + '-' + getClass();
    }

    @Override // bga.i
    public final void onInit() {
        Intrinsics.checkNotNullParameter("AiIslandVoiceInteractionSession", "tag");
        Intrinsics.checkNotNullParameter("AiIslandVoiceInteractionSession", "tag");
        this.f391620a = "AiIslandVoiceInteractionSession";
    }

    public static String b() {
        ISessionMaintaining r100 = j.b();
        if (r100 == null) goto L6;
        String r101 = r100.w();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }
}
