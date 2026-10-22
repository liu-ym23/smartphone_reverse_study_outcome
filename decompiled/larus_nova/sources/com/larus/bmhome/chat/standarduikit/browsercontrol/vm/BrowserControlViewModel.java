package com.larus.bmhome.chat.standarduikit.browsercontrol.vm;

import com.larus.bmhome.chat.standarduikit.browsercontrol.view.ButtonStatus;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes26.dex */
public final class BrowserControlViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f308938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f308939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ButtonStatus f308940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f308941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f308942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f308943f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f308944g;

    public BrowserControlViewModel() {
        this.f308940c = ButtonStatus.ENABLED;
        this.f308944g = LazyKt.lazy(new d(this));
    }
}
