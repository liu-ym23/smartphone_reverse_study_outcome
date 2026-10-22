package r3;

import com.bytedance.ai.applet.components.input.AppletChatActionBarCapability;
import com.bytedance.ai.bridge.doubao.chat.AbsSetChatActionBarMethodIDL;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f535850a;

    /* JADX INFO: renamed from: r3.a$a, reason: collision with other inner class name */
    public static final class C7427a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f535851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f535852b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f535851a, r101.f535851a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f535852b, r101.f535852b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f535851a.hashCode() * 31) + this.f535852b.hashCode();
        }

        public final String toString() {
            return "ParsedIcon(light=" + this.f535851a + ", dark=" + this.f535852b + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "light");
            Intrinsics.checkNotNullParameter(r101, "dark");
            this.f535851a = r100;
            this.f535852b = r101;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f535853a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f535854b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f535855c = null;

        static {
            int[] r100 = new int[AbsSetChatActionBarMethodIDL.ChatActionBarItemKind.values().length];
            r100[AbsSetChatActionBarMethodIDL.ChatActionBarItemKind.ACTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L29:
            r100[AbsSetChatActionBarMethodIDL.ChatActionBarItemKind.ACTION_GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L6:
            f535853a = r100;
            int[] r101 = new int[AbsSetChatActionBarMethodIDL.ChatActionBarActionType.values().length];
            r101[AbsSetChatActionBarMethodIDL.ChatActionBarActionType.SEND_PROMPT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L39:
            r101[AbsSetChatActionBarMethodIDL.ChatActionBarActionType.OPEN_SCHEMA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L33:
            r101[AbsSetChatActionBarMethodIDL.ChatActionBarActionType.OPEN_CAPABILITY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L11:
            f535854b = r101;
            int[] r102 = new int[AbsSetChatActionBarMethodIDL.ChatActionBarCapability.values().length];
            r102[AbsSetChatActionBarMethodIDL.ChatActionBarCapability.OPEN_CAMERA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L35:
            r102[AbsSetChatActionBarMethodIDL.ChatActionBarCapability.MUSIC_GENERATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L25:
            r102[AbsSetChatActionBarMethodIDL.ChatActionBarCapability.IMAGE_GENERATION.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L15:
            f535855c = r102;
        }
    }

    static {
    }

    public a() {
        this.f535850a = new LinkedHashSet();
    }

    public final void c(String r100) {
        if ((!StringsKt.isBlank(r100)) == false) goto L10;
        if (this.f535850a.add(r100) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(("item id " + r100 + " is duplicated").toString());
    L10:
        throw new IllegalArgumentException("item id is empty".toString());
    }

    public static r2.a a(AbsSetChatActionBarMethodIDL.ChatActionBarAction r100, String r101) {
        boolean r102 = false;
        if (r100 == null) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L74;
        int r104 = c.f535854b[r100.getType().ordinal()];
        if (r104 == 1) goto L59;
        if (r104 == 2) goto L45;
        if (r104 != 3) goto L43;
        if (r100.getPrompt() != null) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L41;
        if (r100.getSchema() != null) goto L21;
        r102 = true;
    L21:
        if (r102 == false) goto L39;
        AbsSetChatActionBarMethodIDL.ChatActionBarCapability r106 = r100.getCapability();
        if (r106 != null) goto L25;
        int r107 = -1;
    L26:
        if (r107 == (-1)) goto L37;
        if (r107 == 1) goto L34;
        if (r107 == 2) goto L33;
        if (r107 != 3) goto L32;
        AppletChatActionBarCapability r108 = AppletChatActionBarCapability.IMAGE_GENERATION;
    L75:
        return new r2.a.C7424a(r108);
    L32:
        throw new NoWhenBranchMatchedException();
    L33:
        r108 = AppletChatActionBarCapability.MUSIC_GENERATION;
        goto L75
    L34:
        r108 = AppletChatActionBarCapability.OPEN_CAMERA;
        goto L75
    L37:
        throw new IllegalArgumentException(r101 + " action.capability is empty");
    L25:
        r107 = c.f535855c[r106.ordinal()];
        goto L26
    L39:
        throw new IllegalArgumentException((r101 + " action.schema must be empty").toString());
    L41:
        throw new IllegalArgumentException((r101 + " action.prompt must be empty").toString());
    L16:
        r105 = false;
        goto L17
    L43:
        throw new NoWhenBranchMatchedException();
    L45:
        if (r100.getPrompt() != null) goto L47;
        boolean r109 = true;
    L48:
        if (r109 == false) goto L57;
        if (r100.getCapability() != null) goto L52;
        r102 = true;
    L52:
        if (r102 == false) goto L55;
        return new r2.a.b(d(r100.getSchema(), r101 + " action.schema is empty"));
    L55:
        throw new IllegalArgumentException((r101 + " action.capability must be empty").toString());
    L57:
        throw new IllegalArgumentException((r101 + " action.prompt must be empty").toString());
    L47:
        r109 = false;
        goto L48
    L59:
        if (r100.getSchema() != null) goto L61;
        boolean r110 = true;
    L62:
        if (r110 == false) goto L72;
        if (r100.getCapability() != null) goto L66;
        r102 = true;
    L66:
        if (r102 == false) goto L70;
        return new r2.a.c(d(r100.getPrompt(), r101 + " action.prompt is empty"));
    L70:
        throw new IllegalArgumentException((r101 + " action.capability must be empty").toString());
    L72:
        throw new IllegalArgumentException((r101 + " action.schema must be empty").toString());
    L61:
        r110 = false;
        goto L62
    L74:
        throw new IllegalArgumentException((r101 + " action is empty").toString());
    L5:
        r103 = false;
        goto L6
    }

    public static b b(AbsSetChatActionBarMethodIDL.ChatActionBarIcon r100, String r101) {
        return new b(d(r100.getLight(), r101 + " icon.light is empty"), d(r100.getDark(), r101 + " icon.dark is empty"));
    }

    public static String d(String r100, String r101) {
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if ((true ^ r102) == false) goto L15;
        if (r100 != null) goto L16;
        return "";
    L16:
        return r100;
    L15:
        throw new IllegalArgumentException(r101.toString());
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L10
    }
}
