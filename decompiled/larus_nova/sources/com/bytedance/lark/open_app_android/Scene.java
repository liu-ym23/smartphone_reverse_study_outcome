package com.bytedance.lark.open_app_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/bytedance/lark/open_app_android/Scene;", "", "(Ljava/lang/String;I)V", "into", "Lopen_app/proto/Scene;", "intoInt", "", "PlusMenu", "MessageAction", "Companion", "open_app_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum Scene extends Enum<Scene> {
    public static final a Companion = null;
    public static final Scene MessageAction = null;
    public static final Scene PlusMenu = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Scene[] f253413a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f253414b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253415a = null;

        static {
            int[] r100 = new int[Scene.values().length];
            r100[Scene.PlusMenu.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[Scene.MessageAction.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f253415a = r100;
        }
    }

    public static EnumEntries<Scene> getEntries() {
        return f253414b;
    }

    public static Scene valueOf(String r100) {
        return (Scene) r27.a.a(Scene.class, r100);
    }

    public static Scene[] values() {
        return (Scene[]) f253413a.clone();
    }

    static {
        Scene r100 = new Scene("PlusMenu", 0);
        PlusMenu = r100;
        Scene r101 = new Scene("MessageAction", 1);
        MessageAction = r101;
        Scene[] r102 = {r100, r101};
        f253413a = r102;
        f253414b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public final open_app.proto.Scene into() {
        int r100 = b.f253415a[ordinal()];
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L8;
        return open_app.proto.Scene.VAR_SCENE_MESSAGE_ACTION;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return open_app.proto.Scene.VAR_SCENE_PLUS_MENU;
    }

    public final int intoInt() {
        int r100 = b.f253415a[ordinal()];
        if (r100 != 1) goto L5;
        return 0;
    L5:
        if (r100 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final Scene fromInt(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return MessageAction;
    L8:
        throw new RuntimeException("Unmatched primitive enum value: Scene with ");
    L10:
        return PlusMenu;
    }

    public Scene(String r100, int r101) {
        super(r100, r101);
    }
}
