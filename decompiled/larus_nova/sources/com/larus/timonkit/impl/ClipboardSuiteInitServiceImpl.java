package com.larus.timonkit.impl;

import com.bytedance.timon.clipboard.suite.ITMClipboardSuiteInitService;
import com.bytedance.timon.clipboard.suite.TimonClipboardSuite;
import com.google.gson.JsonObject;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import sx9.b;
import sx9.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/larus/timonkit/impl/ClipboardSuiteInitServiceImpl;", "Lcom/bytedance/timon/clipboard/suite/ITMClipboardSuiteInitService;", "<init>", "()V", "hasInit", "", "loadDefaultConfig", "Lcom/google/gson/JsonObject;", "makeSureSuiteInit", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClipboardSuiteInitServiceImpl implements ITMClipboardSuiteInitService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f370132b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f370133a;

    public static final class a {
    }

    static {
    }

    public ClipboardSuiteInitServiceImpl() {
    }

    @Override // com.bytedance.timon.clipboard.suite.ITMClipboardSuiteInitService
    public final boolean a() {
        boolean r100 = true;
        if (this.f370133a == false) goto L6;
        FLogger.f375446a.d("TMClipboardSuiteTask", "makeSureSuiteInit hasAlreadyInit");
        return true;
    L6:
        FLogger r101 = FLogger.f375446a;
        r101.d("TMClipboardSuiteTask", "start makeSureSuiteInit");
        this.f370133a = true;
        TimonClipboardSuite r102 = TimonClipboardSuite.f270597l;
        Function0<Boolean> r103 = new b();
        r102.getClass();
        TimonClipboardSuite.f270588c = r103;
        r101.i("TMClipboardSuiteTask", "makeSureSuiteInit registerConfigProvider");
        Function0<JsonObject> r104 = new c(this);
        if (TimonClipboardSuite.f270594i != null) goto L10;
        r100 = false;
    L10:
        if (r100 == true) goto L13;
        rg7.a.f537715d = r104;
    L13:
        TimonClipboardSuite.p(AppHost.f326268a.getApplication());
        r101.d("TMClipboardSuiteTask", "finish makeSureSuiteInit");
        return this.f370133a;
    }
}
