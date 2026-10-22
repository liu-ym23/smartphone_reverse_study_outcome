package com.larksuite.component.blockit.entity;

import com.larksuite.component.blockit.entity.richtext.RichTextMessage;
import com.larksuite.component.blockit.entity.todo.MultiMessage;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public class BlockExtra implements Serializable {
    public String contextJson;
    public Map<String, Object> hitPointParams;
    public MultiMessage multiMessage;
    public String parentMsgSenderId;
    public RichTextMessage richTextMessage;
    public SceneType sceneType;

    public static final enum SceneType extends Enum<SceneType> {
        public static final SceneType CHAT_MULTI = null;
        public static final SceneType INPUT_BOX = null;
        public static final SceneType MESSAGE_TOOLBAR = null;
        public static final SceneType THREAD_MULTI = null;
        public static final SceneType THREAD_REPLY = null;
        public static final SceneType THREAD_TOPIC = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SceneType[] f282978a = null;
        private final int value;

        static {
            SceneType r100 = new SceneType("THREAD_TOPIC", 0, 1);
            THREAD_TOPIC = r100;
            SceneType r101 = new SceneType("THREAD_REPLY", 1, 2);
            THREAD_REPLY = r101;
            SceneType r102 = new SceneType("THREAD_MULTI", 2, 3);
            THREAD_MULTI = r102;
            SceneType r103 = new SceneType("MESSAGE_TOOLBAR", 3, 4);
            MESSAGE_TOOLBAR = r103;
            SceneType r104 = new SceneType("INPUT_BOX", 4, 5);
            INPUT_BOX = r104;
            SceneType r110 = new SceneType("CHAT_MULTI", 5, 6);
            CHAT_MULTI = r110;
            f282978a = new SceneType[]{r100, r101, r102, r103, r104, r110};
        }

        public static SceneType[] values() {
            return (SceneType[]) f282978a.clone();
        }

        public static SceneType valueOf(String r100) {
            return (SceneType) r27.a.a(SceneType.class, r100);
        }

        public SceneType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public BlockExtra() {
    }

    public Map<String, Object> getHitPointParams() {
        Map<String, Object> r100 = this.hitPointParams;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new HashMap();
    }
}
