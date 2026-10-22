package com.bytedance.timon.pipeline;

import com.obric.miniapp.alarm.AccountType;
import dh7.c;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
public interface TimonSystem {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/timon/pipeline/TimonSystem$InvokeType;", "", "PRE_INVOKE", "POST_INVOKE", AccountType.ALL, "pipeline_release"}, k = 1, mv = {1, 4, 0})
    public static final enum InvokeType extends Enum<InvokeType> {
        public static final InvokeType ALL = null;
        public static final InvokeType POST_INVOKE = null;
        public static final InvokeType PRE_INVOKE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InvokeType[] f270673a = null;

        static {
            InvokeType r100 = new InvokeType("PRE_INVOKE", 0);
            PRE_INVOKE = r100;
            InvokeType r101 = new InvokeType("POST_INVOKE", 1);
            POST_INVOKE = r101;
            InvokeType r102 = new InvokeType(AccountType.ALL, 2);
            ALL = r102;
            f270673a = new InvokeType[]{r100, r101, r102};
        }

        public static InvokeType valueOf(String r100) {
            return (InvokeType) r27.a.a(InvokeType.class, r100);
        }

        public static InvokeType[] values() {
            return (InvokeType[]) f270673a.clone();
        }

        public InvokeType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements TimonSystem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f270674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TimonSystem f270675b;

        @Override // com.bytedance.timon.pipeline.TimonSystem
        public final boolean preInvoke(c r100) {
            return false;
        }

        @Override // com.bytedance.timon.pipeline.TimonSystem
        public final String name() {
            return this.f270674a;
        }

        @Override // com.bytedance.timon.pipeline.TimonSystem
        public final boolean postInvoke(c r100) {
            return this.f270675b.postInvoke(r100);
        }

        public a(String r100, TimonSystem r101) {
            this.f270674a = r100;
            this.f270675b = r101;
        }
    }

    public static final class b implements TimonSystem {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f270676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TimonSystem f270677b;

        @Override // com.bytedance.timon.pipeline.TimonSystem
        public final boolean postInvoke(c r100) {
            return false;
        }

        @Override // com.bytedance.timon.pipeline.TimonSystem
        public final String name() {
            return this.f270676a;
        }

        @Override // com.bytedance.timon.pipeline.TimonSystem
        public final boolean preInvoke(c r100) {
            return this.f270677b.preInvoke(r100);
        }

        public b(String r100, TimonSystem r101) {
            this.f270676a = r100;
            this.f270677b = r101;
        }
    }

    String name();

    boolean postInvoke(c r100);

    boolean preInvoke(c r100);
}
