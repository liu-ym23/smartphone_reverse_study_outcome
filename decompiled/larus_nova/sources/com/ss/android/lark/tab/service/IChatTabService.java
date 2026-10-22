package com.ss.android.lark.tab.service;

import com.bytedance.sdk.bridge.annotation.BridgeSyncType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
public interface IChatTabService {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/tab/service/IChatTabService$SyncStrategy;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", BridgeSyncType.SYNC, "OLD_THEN_TRIGGER", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SyncStrategy extends Enum<SyncStrategy> {
        public static final a Companion = null;
        public static final SyncStrategy OLD_THEN_TRIGGER = null;
        public static final SyncStrategy SYNC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SyncStrategy[] f441138a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f441139b = null;
        private final int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<SyncStrategy> getEntries() {
            return f441139b;
        }

        static {
            SyncStrategy r100 = new SyncStrategy(BridgeSyncType.SYNC, 0, 0);
            SYNC = r100;
            SyncStrategy r101 = new SyncStrategy("OLD_THEN_TRIGGER", 1, 1);
            OLD_THEN_TRIGGER = r101;
            SyncStrategy[] r102 = {r100, r101};
            f441138a = r102;
            f441139b = EnumEntriesKt.enumEntries(r102);
            Companion = new a();
        }

        public static SyncStrategy[] values() {
            return (SyncStrategy[]) f441138a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static SyncStrategy valueOf(String r100) {
            return (SyncStrategy) r27.a.a(SyncStrategy.class, r100);
        }

        public SyncStrategy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }
}
