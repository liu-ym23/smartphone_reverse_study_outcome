package com.ss.android.lark.biz.im.api.extension.keyboard.inputstate;

import cya.g;
import cya.h;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public interface InputStateHandler<S extends h> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/keyboard/inputstate/InputStateHandler$TransformResult;", "", "<init>", "(Ljava/lang/String;I)V", "KeepFrom", "KeepTo", "KeepBoth", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TransformResult extends Enum<TransformResult> {
        public static final TransformResult KeepBoth = null;
        public static final TransformResult KeepFrom = null;
        public static final TransformResult KeepTo = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TransformResult[] f410148a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f410149b = null;

        public static EnumEntries<TransformResult> getEntries() {
            return f410149b;
        }

        static {
            TransformResult r100 = new TransformResult("KeepFrom", 0);
            KeepFrom = r100;
            TransformResult r101 = new TransformResult("KeepTo", 1);
            KeepTo = r101;
            TransformResult r102 = new TransformResult("KeepBoth", 2);
            KeepBoth = r102;
            TransformResult[] r103 = {r100, r101, r102};
            f410148a = r103;
            f410149b = EnumEntriesKt.enumEntries(r103);
        }

        public static TransformResult[] values() {
            return (TransformResult[]) f410148a.clone();
        }

        public static TransformResult valueOf(String r100) {
            return (TransformResult) a.a(TransformResult.class, r100);
        }

        public TransformResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    g<?> a();

    TransformResult b(h r100, S r101);

    int getCode();
}
