package androidx.compose.foundation.text.input.internal.selection;

import android.content.ClipDescription;
import android.content.ClipboardManager;
import androidx.compose.ui.platform.Clipboard;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/ClipboardPasteState;", "", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "<init>", "(Landroidx/compose/ui/platform/Clipboard;)V", "_hasClip", "", "_hasText", "hasText", "getHasText", "()Z", "hasClip", "getHasClip", "update", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClipboardPasteState {
    public static final int $stable = 8;
    private boolean _hasClip;
    private boolean _hasText;
    private final Clipboard clipboard;

    public final boolean getHasClip() {
        return this._hasClip;
    }

    public final boolean getHasText() {
        return this._hasText;
    }

    public ClipboardPasteState(Clipboard r1) {
        this.clipboard = r1;
    }

    private static ClipDescription androidx_compose_foundation_text_input_internal_selection_ClipboardPasteState_android_content_ClipboardManager_getPrimaryClipDescription(ClipboardManager r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101809);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(101809, "android/content/ClipboardManager", "getPrimaryClipDescription", r18, r10, "android.content.ClipDescription", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ClipDescription) r4.b;
    L21:
        return r18.getPrimaryClipDescription();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static boolean androidx_compose_foundation_text_input_internal_selection_ClipboardPasteState_android_content_ClipboardManager_hasPrimaryClip(ClipboardManager r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(101805);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(101805, "android/content/ClipboardManager", "hasPrimaryClip", r18, r10, "boolean", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Boolean) r4.b).booleanValue();
    L21:
        return r18.hasPrimaryClip();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public final Object update(Continuation<? super Unit> r4) {
        boolean r5 = androidx_compose_foundation_text_input_internal_selection_ClipboardPasteState_android_content_ClipboardManager_hasPrimaryClip(this.clipboard.getNativeClipboard());
        this._hasClip = r5;
        boolean r0 = false;
        if (r5 == false) goto L12;
        ClipDescription r6 = androidx_compose_foundation_text_input_internal_selection_ClipboardPasteState_android_content_ClipboardManager_getPrimaryClipDescription(this.clipboard.getNativeClipboard());
        if (r6 != null) goto L7;
    L9:
        boolean r7 = false;
    L10:
        if (r7 == false) goto L12;
        r0 = true;
        goto L12
    L7:
        if (r6.hasMimeType("text/*") != true) goto L9;
        r7 = true;
    L12:
        this._hasText = r0;
        return Unit.INSTANCE;
    }
}
