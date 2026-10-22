package com.bytedance.ee.bear.list.folderselect.command;

import android.content.Context;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class DuplicateContentChecker {
    public static final /* synthetic */ int a = 0;

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

        public CheckShortcutResult(boolean r1, boolean r2) {
            this.hasShortcut = r1;
            this.hasEntity = r2;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/list/folderselect/command/DuplicateContentChecker$DuplicateResult;", "", "<init>", "(Ljava/lang/String;I)V", "NoDuplicate", "DuplicateAndUserConfirm", "DuplicateAndUserCancel", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DuplicateResult extends Enum<DuplicateResult> {
        public static final DuplicateResult DuplicateAndUserCancel = null;
        public static final DuplicateResult DuplicateAndUserConfirm = null;
        public static final DuplicateResult NoDuplicate = null;
        public static final /* synthetic */ DuplicateResult[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<DuplicateResult> getEntries() {
            return b;
        }

        static {
            DuplicateResult r0 = new DuplicateResult("NoDuplicate", 0);
            NoDuplicate = r0;
            DuplicateResult r1 = new DuplicateResult("DuplicateAndUserConfirm", 1);
            DuplicateAndUserConfirm = r1;
            DuplicateResult r3 = new DuplicateResult("DuplicateAndUserCancel", 2);
            DuplicateAndUserCancel = r3;
            DuplicateResult[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static DuplicateResult[] values() {
            return (DuplicateResult[]) a.clone();
        }

        public static DuplicateResult valueOf(String r1) {
            return (DuplicateResult) r27.a.a(DuplicateResult.class, r1);
        }

        public DuplicateResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a<T, R> implements Function {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public a(Context r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object apply(Object r5) {
            final CheckShortcutResult r6 = (CheckShortcutResult) r5;
            Intrinsics.checkNotNullParameter(r6, "res");
            final Context r1 = this.a;
            final String r2 = this.b;
            final int r3 = this.c;
            return Flowable.create(new DuplicateContentChecker$checkDuplicateContent$1$1(r6, r1, r2, r3), BackpressureStrategy.BUFFER);
        }
    }

    static {
    }

    @JvmStatic
    public static final Flowable<DuplicateResult> a(Context r2, String r3, String r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r3 == null) goto L9;
        if (r4 == null) goto L9;
        NetService.f r0 = new NetService.f("/space/api/bff/workspace/check_shortcut");
        ((NetService.e) r0).c = 2;
        r0.b("parent_node_token", r3);
        r0.b(ResourceData.KEY_OBJ_TOKEN, r4);
        r0.b("obj_type", String.valueOf(r5));
        r0.b("biz_type", String.valueOf(r6));
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(com.bytedance.ee.bear.list.folderselect.command.a.a).a(r0).flatMap(new a(r2, r4, r5));
    L9:
        return Flowable.error(new NullPointerException("parentNodeToken or objToken npe!"));
    }
}
