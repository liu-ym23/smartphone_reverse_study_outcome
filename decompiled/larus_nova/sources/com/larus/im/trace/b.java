package com.larus.im.trace;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kotlin.Deprecated;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "use IMSendTrace & IMReceiveTrace")
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f350906a;

    public b() {
        this.f350906a = new GsonBuilder().create();
    }
}
