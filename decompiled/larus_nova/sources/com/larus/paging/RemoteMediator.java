package com.larus.paging;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@ExperimentalPagingApi
public abstract class RemoteMediator<Key, Value> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/paging/RemoteMediator$InitializeAction;", "", "LAUNCH_INITIAL_REFRESH", "SKIP_INITIAL_REFRESH", "paging-common_release"}, k = 1, mv = {1, 7, 1})
    public static final enum InitializeAction extends Enum<InitializeAction> {
        public static final InitializeAction LAUNCH_INITIAL_REFRESH = null;
        public static final InitializeAction SKIP_INITIAL_REFRESH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InitializeAction[] f363734a = null;

        public static InitializeAction valueOf(String r100) {
            return (InitializeAction) r27.a.a(InitializeAction.class, r100);
        }

        public static InitializeAction[] values() {
            return (InitializeAction[]) f363734a.clone();
        }

        static {
            InitializeAction r100 = new InitializeAction("LAUNCH_INITIAL_REFRESH", 0);
            LAUNCH_INITIAL_REFRESH = r100;
            InitializeAction r101 = new InitializeAction("SKIP_INITIAL_REFRESH", 1);
            SKIP_INITIAL_REFRESH = r101;
            f363734a = new InitializeAction[]{r100, r101};
        }

        public InitializeAction(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.paging.RemoteMediator$a$a, reason: collision with other inner class name */
        public static final class C4456a extends a {
        }

        public static final class b extends a {
        }

        public a() {
        }
    }
}
