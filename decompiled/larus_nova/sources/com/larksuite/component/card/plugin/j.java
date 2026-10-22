package com.larksuite.component.card.plugin;

import android.content.DialogInterface;
import com.ss.android.lark.lynxkit.bridge.ILynxBridgeContext;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes24.dex */
public final class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j18.f<CallbackProcessResponse> f283807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<ILynxBridgeContext> f283808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f283809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f283810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<com.larksuite.component.card.cardcontainer.c> f283811e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f283812f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f283813g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<OPTrace> f283814h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ boolean f283815i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f283816j;

    public j(j18.f r100, Ref.ObjectRef r101, String r102, Ref.ObjectRef r103, String r104, Map r105, Ref.ObjectRef r106) {
        this.f283807a = r100;
        this.f283808b = r101;
        this.f283809c = "";
        this.f283810d = r102;
        this.f283811e = r103;
        this.f283812f = r104;
        this.f283813g = r105;
        this.f283814h = r106;
        this.f283815i = false;
        this.f283816j = "input";
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r110, int r111) {
        this.f283807a.callback(new CallbackProcessResponse());
        int r112 = k.f283817a;
        k.b(this.f283808b.element, this.f283809c, this.f283810d, this.f283811e.element, this.f283812f, this.f283813g, this.f283814h.element, this.f283815i, this.f283816j);
    }
}
