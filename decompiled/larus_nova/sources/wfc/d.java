package wfc;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.photoeditor.base.view.ColorChoiceView;
import com.ss.android.photoeditor.text.TextPhotoEditorPlugin;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements ColorChoiceView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextPhotoEditorPlugin f559508a;

    public d(TextPhotoEditorPlugin r100) {
        this.f559508a = r100;
    }

    @Override // com.ss.android.photoeditor.base.view.ColorChoiceView.b
    public final void a(int r100, ColorChoiceView.ChoiceColor r101) {
        this.f559508a.f449513a.setPaintColor(r100);
        sfc.a.C7605a r102 = sfc.a.f541747a;
        int r103 = r101.ID;
        r102.getClass();
        ((ArrayList) sfc.a.f541757k).add(Integer.valueOf(r103));
        Intrinsics.checkNotNullParameter("thickness", SocialConstants.PARAM_ACT);
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L9
        if (sfc.a.f541758l == null) goto L6;
        Statistics.sendEvent("public_pic_edit_text_label_click", new JSONObject().put("click", "thickness").put(PickerReporterConstants.KEY.TARGET, "none"));     // Catch: Throwable -> L9
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L9
    L11:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L17;
        Log.e("HitPointHelper", "sendPicEditTextLabelClickEvent error. t: " + r107.getMessage());
        return;
    L17:
        return;
    L6:
        r105 = null;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
