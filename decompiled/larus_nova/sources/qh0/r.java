package qh0;

import android.app.Activity;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.bytedance.android.livesdk.config.eb0;
import com.bytedance.android.livesdk.config.mb1;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class r extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f532938a;

    public r(Activity r100) {
        this.f532938a = r100;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        eb0 r101 = eb0.f120113a;
        mb1 r102 = r101.getValue();
        String r103 = null;
        if (r102 == null) goto L5;
        String r104 = r102.b();
    L7:
        if (TextUtils.isEmpty(r104) == true) goto L13;
        IBaseLiveActionHandler r105 = (IBaseLiveActionHandler) jc1.k.n(IBaseLiveActionHandler.class);
        Activity r106 = this.f532938a;
        mb1 r107 = r101.getValue();
        if (r107 == null) goto L11;
        r103 = r107.b();
    L11:
        r105.handle(r106, r103);
        return;
    L13:
        return;
    L5:
        r104 = null;
        goto L7
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        Intrinsics.checkNotNullParameter(r100, "ds");
        super.updateDrawState(r100);
        r100.setColor(FakePickerAvatarCreator.BLUE);
        r100.setUnderlineText(true);
    }
}
