package com.bytedance.ee.bear.list.folderselect.command;

import android.content.Context;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class DuplicateContentChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f228115a = 0;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/list/folderselect/command/DuplicateContentChecker$CheckShortcutResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "hasShortcut", "", "hasEntity", "<init>", "(ZZ)V", "getHasShortcut", "()Z", "getHasEntity", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CheckShortcutResult extends Result<Serializable> {
        private final boolean hasEntity;
        private final boolean hasShortcut;

        public final boolean getHasEntity() {
            return this.hasEntity;
        }

        public final boolean getHasShortcut() {
            return this.hasShortcut;
        }

        public CheckShortcutResult(boolean r100, boolean r101) {
            this.hasShortcut = r100;
            this.hasEntity = r101;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/list/folderselect/command/DuplicateContentChecker$DuplicateResult;", "", "<init>", "(Ljava/lang/String;I)V", "NoDuplicate", "DuplicateAndUserConfirm", "DuplicateAndUserCancel", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DuplicateResult extends Enum<DuplicateResult> {
        public static final DuplicateResult DuplicateAndUserCancel = null;
        public static final DuplicateResult DuplicateAndUserConfirm = null;
        public static final DuplicateResult NoDuplicate = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DuplicateResult[] f228116a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f228117b = null;

        public static EnumEntries<DuplicateResult> getEntries() {
            return f228117b;
        }

        static {
            DuplicateResult r100 = new DuplicateResult("NoDuplicate", 0);
            NoDuplicate = r100;
            DuplicateResult r101 = new DuplicateResult("DuplicateAndUserConfirm", 1);
            DuplicateAndUserConfirm = r101;
            DuplicateResult r102 = new DuplicateResult("DuplicateAndUserCancel", 2);
            DuplicateAndUserCancel = r102;
            DuplicateResult[] r103 = {r100, r101, r102};
            f228116a = r103;
            f228117b = EnumEntriesKt.enumEntries(r103);
        }

        public static DuplicateResult[] values() {
            return (DuplicateResult[]) f228116a.clone();
        }

        public static DuplicateResult valueOf(String r100) {
            return (DuplicateResult) r27.a.a(DuplicateResult.class, r100);
        }

        public DuplicateResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f228118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f228119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f228120c;

        public a(Context r100, String r101, int r102) {
            this.f228118a = r100;
            this.f228119b = r101;
            this.f228120c = r102;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            final CheckShortcutResult r101 = (CheckShortcutResult) r100;
            Intrinsics.checkNotNullParameter(r101, "res");
            final Context r102 = this.f228118a;
            final String r103 = this.f228119b;
            final int r104 = this.f228120c;
            return Flowable.create(new DuplicateContentChecker$checkDuplicateContent$1$1(r101, r102, r103, r104), BackpressureStrategy.BUFFER);
        }
    }

    static {
    }

    @JvmStatic
    public static final Flowable<DuplicateResult> a(Context r100, String r101, String r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 == null) goto L9;
        if (r102 == null) goto L9;
        NetService.f r105 = new NetService.f("/space/api/bff/workspace/check_shortcut");
        r105.f216906c = 2;
        r105.b("parent_node_token", r101);
        r105.b("obj_token", r102);
        r105.b("obj_type", String.valueOf(r103));
        r105.b("biz_type", String.valueOf(r104));
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(com.bytedance.ee.bear.list.folderselect.command.a.f228125a).a(r105).flatMap(new a(r100, r102, r103));
    L9:
        return Flowable.error(new NullPointerException("parentNodeToken or objToken npe!"));
    }
}
