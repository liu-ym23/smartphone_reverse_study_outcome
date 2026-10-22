package jab;

import com.ss.android.lark.create.groupchat.dto.CreateGroupMode;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends q5c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f497971a = 0;

    public static final class a {

        /* JADX INFO: renamed from: jab.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C6409a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f497972a = null;

            static {
                int[] r100 = new int[CreateGroupMode.values().length];
                r100[CreateGroupMode.CONVERSATION_MODE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[CreateGroupMode.TOPIC_MODE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f497972a = r100;
            }
        }
    }

    static {
    }
}
