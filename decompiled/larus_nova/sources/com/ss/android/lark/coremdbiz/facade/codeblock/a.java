package com.ss.android.lark.coremdbiz.facade.codeblock;

import com.ss.android.lark.coremd.impl.parse.i;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import kotlin.jvm.internal.Intrinsics;
import v7b.g;

/* JADX INFO: loaded from: classes35.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C4950a f420076a = null;

    /* JADX INFO: renamed from: com.ss.android.lark.coremdbiz.facade.codeblock.a$a, reason: collision with other inner class name */
    public static final class C4950a implements a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ C4950a f420077b = null;

        static {
            f420077b = new C4950a();
        }

        public C4950a() {
        }

        @Override // com.ss.android.lark.coremdbiz.facade.codeblock.a
        public final CodeBlockV2ProcessParams a(g r100, final i r101) {
            Intrinsics.checkNotNullParameter(r100, "node");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            int r102 = ((Number) LarkContextExtend.f419979s.b(new ICodeBlockParamsProvider$Default$provide$maxWidth$1(r101))).intValue();
            return CodeBlockV2ProcessParams.b.d(CodeBlockV2ProcessParams.Companion, r102, 0, 6);
        }
    }

    static {
        f420076a = C4950a.f420077b;
    }

    CodeBlockV2ProcessParams a(g r100, i r101);
}
