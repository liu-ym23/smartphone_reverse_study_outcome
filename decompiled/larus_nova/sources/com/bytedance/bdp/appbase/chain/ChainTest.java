package com.bytedance.bdp.appbase.chain;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class ChainTest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f200670a = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/ChainTest$TestEvent;", "Lcom/bytedance/bdp/appbase/chain/Event;", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
    public static class TestEvent extends Event {
        public TestEvent() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/bdp/appbase/chain/ChainTest$TestEvent2;", "Lcom/bytedance/bdp/appbase/chain/ChainTest$TestEvent;", "()V", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
    public static final class TestEvent2 extends TestEvent {
        public TestEvent2() {
        }
    }

    public static final class a {
        @JvmStatic
        public static void a(boolean r100, String r101) {
            if (r100 == true) goto L8;
            StringBuilder r102 = new StringBuilder("CnTest:");
            int r103 = ChainTest.f200670a;
            if (r101 != null) goto L6;
            r101 = "assert error!";
        L6:
            r102.append(r101);
            throw new Exception(r102.toString());
        }
    }

    static {
    }
}
