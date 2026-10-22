package com.bytedance.ee.bear.task;

import android.app.Application;
import android.content.Context;
import com.bytedance.ee.bear.basesdk.config.j;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.onboarding.export.OnBoardingColorStyle;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larksuite.framework.launch.task.ILaunchTask;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.koin.java.a;
import sk5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DocsOnBoardingTask extends BaseAsyncLaunchTask {
    public final List<Class<? extends ILaunchTask>> i() {
        ArrayList r0 = new ArrayList();
        r0.add(DocsCentralTask.class);
        return r0;
    }

    public DocsOnBoardingTask() {
    }

    @Override // com.bytedance.ee.bear.task.BaseAsyncLaunchTask
    public final void a(Context r5) {
        b r6 = (b) a.a(b.class);
        Application r0 = eu5.b.a;
        Map r1 = j.a;
        OnBoardingColorStyle r2 = OnBoardingColorStyle.Blue;
        r6.init(MapsKt.mapOf(new Pair[]{TuplesKt.to(DocumentType.DOC_NAME, r2), TuplesKt.to(DocumentType.SHEET_NAME, r2), TuplesKt.to(DocumentType.WIKI_NAME, r2), TuplesKt.to(DocumentType.BITABLE_NAME, r2), TuplesKt.to("space", r2), TuplesKt.to(DocumentType.VALUE_DRIVE, r2)}));
        ((h0) a.a(h0.class)).T4().subscribe(new vn5.b(this));
    }
}
