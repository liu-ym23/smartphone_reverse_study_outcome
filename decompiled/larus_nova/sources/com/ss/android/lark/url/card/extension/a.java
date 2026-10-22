package com.ss.android.lark.url.card.extension;

import com.ss.android.lark.export.extension.UrlPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UrlPlugin
public final class a implements zcb.b {

    /* JADX INFO: renamed from: com.ss.android.lark.url.card.extension.a$a, reason: collision with other inner class name */
    public static final class C5371a {
    }

    public static final class b implements com.ss.android.lark.export.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UrlCardEngineFactory f444623a;

        @Override // com.ss.android.lark.export.b
        public final void clear() {
            UrlCardEngineFactory r100 = this.f444623a;
            r100.getClass();
            if (UrlCardEngineFactory.f444620b.getValue().booleanValue() == false) goto L5;
            return;
        L5:
            if (r100.f444621a.size() <= 0) goto L14;
            Iterator<com.ss.android.lark.url.card.a> r101 = r100.f444621a.iterator();
        L8:
            if (r101.hasNext() == false) goto L10;
            r101.next().getClass();
            goto L8
        L10:
            r100.f444621a.clear();
            return;
        }

        public b(UrlCardEngineFactory r100) {
            this.f444623a = r100;
        }
    }

    static {
    }

    public a() {
    }

    @Override // zcb.b
    public final void a(zcb.a r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        UrlCardEngineFactory r101 = new UrlCardEngineFactory();
        r100.a(new b(r101));
        r100.b(r101);
    }
}
