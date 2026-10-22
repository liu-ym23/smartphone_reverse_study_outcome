package com.larus.receive.impl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.larus.receive.api.IReceiveIntentService;
import com.larus.receive.impl.handler.b;
import com.larus.receive.impl.handler.c;
import com.larus.receive.impl.handler.d;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/receive/impl/ReceiveIntentServiceImpl;", "Lcom/larus/receive/api/IReceiveIntentService;", "<init>", "()V", "handlers", "", "Lcom/larus/receive/impl/handler/IReceiveContentHandler;", "handler", "isReceive", "", "intent", "Landroid/content/Intent;", "parseUris", "", "Landroid/net/Uri;", "handle", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "currentPage", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReceiveIntentServiceImpl implements IReceiveIntentService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f367372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f367373b;

    public static final class a {
    }

    static {
    }

    public ReceiveIntentServiceImpl() {
        ArrayList r100 = new ArrayList();
        this.f367372a = r100;
        r100.add(new c());
        r100.add(new d());
        r100.add(new com.larus.receive.impl.handler.a());
    }

    @Override // com.larus.receive.api.IReceiveIntentService
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("landing", "currentPage");
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("handle, handler:");
        b r103 = this.f367373b;
        if (r103 == null) goto L5;
        String r104 = r103.getName();
    L6:
        r102.append(r104);
        r102.append(",currentPage:landing");
        r101.i("ReceiveIntentServiceImpl", r102.toString());
        b r105 = this.f367373b;
        if (r105 == null) goto L9;
        r105.a(r100);
    L9:
        this.f367373b = null;
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.larus.receive.api.IReceiveIntentService
    public final boolean b(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        String r101 = null;
        if (this.f367373b != null) goto L12;
        Iterator<T> r102 = this.f367372a.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (((b) r103).b(r100) == false) goto L6;
    L11:
        this.f367373b = (b) r103;
        goto L12
    L10:
        r103 = null;
    L12:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("isReceive, type:");
        r105.append(r100.getType());
        r105.append(",handler:");
        b r106 = this.f367373b;
        if (r106 == null) goto L15;
        r101 = r106.getName();
    L15:
        r105.append(r101);
        r104.i("ReceiveIntentServiceImpl", r105.toString());
        if (this.f367373b == null) goto L18;
        return true;
    L18:
        return false;
    }

    @Override // com.larus.receive.api.IReceiveIntentService
    public final List<Uri> c(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        return qs9.a.b(r100);
    }
}
