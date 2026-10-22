package com.bytedance.ee.bear.bitable.superagent;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/MobileSuperAgentOperation;", "", RXScreenCaptureService.KEY_INDEX, "", "<init>", "(Ljava/lang/String;II)V", "getI", "()I", "ENTER", "EXIT", "UPDATE_ALL", "UPDATE_PATCH", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MobileSuperAgentOperation extends Enum<MobileSuperAgentOperation> {
    public static final a Companion = null;
    public static final MobileSuperAgentOperation ENTER = null;
    public static final MobileSuperAgentOperation EXIT = null;
    public static final MobileSuperAgentOperation UPDATE_ALL = null;
    public static final MobileSuperAgentOperation UPDATE_PATCH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MobileSuperAgentOperation[] f215777a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f215778b = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f215779i;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MobileSuperAgentOperation> getEntries() {
        return f215778b;
    }

    static {
        MobileSuperAgentOperation r100 = new MobileSuperAgentOperation("ENTER", 0, 1);
        ENTER = r100;
        MobileSuperAgentOperation r101 = new MobileSuperAgentOperation("EXIT", 1, 2);
        EXIT = r101;
        MobileSuperAgentOperation r102 = new MobileSuperAgentOperation("UPDATE_ALL", 2, 3);
        UPDATE_ALL = r102;
        MobileSuperAgentOperation r103 = new MobileSuperAgentOperation("UPDATE_PATCH", 3, 4);
        UPDATE_PATCH = r103;
        MobileSuperAgentOperation[] r104 = {r100, r101, r102, r103};
        f215777a = r104;
        f215778b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static MobileSuperAgentOperation[] values() {
        return (MobileSuperAgentOperation[]) f215777a.clone();
    }

    public final int getI() {
        return this.f215779i;
    }

    public static MobileSuperAgentOperation valueOf(String r100) {
        return (MobileSuperAgentOperation) r27.a.a(MobileSuperAgentOperation.class, r100);
    }

    public MobileSuperAgentOperation(String r100, int r101, int r102) {
        super(r100, r101);
        this.f215779i = r102;
    }
}
