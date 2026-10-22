package r3;

import com.bytedance.ai.applet.components.input.AppletChatPanelState;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f535857a = null;

    static {
        int[] r100 = new int[AppletChatPanelState.values().length];
        r100[AppletChatPanelState.COLLAPSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
    L13:
        r100[AppletChatPanelState.PREVIEW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
    L19:
        r100[AppletChatPanelState.EXPANDED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
    L15:
        r100[AppletChatPanelState.INVISIBLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
    L7:
        f535857a = r100;
    }
}
