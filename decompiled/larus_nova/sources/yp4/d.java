package yp4;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.bytedance.ee.bear.bitable.card.view.cell.number.STNumberKeyboardView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.bitable.card.view.cell.progress.b f568708a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "s");
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "s");
    }

    public d(com.bytedance.ee.bear.bitable.card.view.cell.progress.b r100) {
        this.f568708a = r100;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
        com.bytedance.ee.bear.bitable.card.view.cell.progress.b r101 = this.f568708a;
        r101.getClass();
        if (r100 == null) goto L42;
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r102 = r101.f207970i;     // Catch: Exception -> L34
        if (r102 != null) goto L7;
    L9:
        boolean r103 = false;
    L11:
        if (r103 == false) goto L22;
        if (r102 == null) goto L16;
        STNumberKeyboardView r104 = r102.f207922b;     // Catch: Exception -> L34
        if (r104 == null) goto L16;
        Editable r105 = r104.getEditableText();     // Catch: Exception -> L34
    L18:
        if (Intrinsics.areEqual(r100, r105) == true) goto L22;
        com.bytedance.ee.bear.bitable.card.view.cell.number.a r106 = r101.f207970i;     // Catch: Exception -> L34
        if (r106 == null) goto L22;
        r106.a(r100);     // Catch: Exception -> L34
    L16:
        r105 = null;
    L22:
        String r107 = r100.toString();     // Catch: Exception -> L34
        if (r101.f207980s == true) goto L25;
    L39:
        r101.i();
        return;
    L25:
        if (TextUtils.isEmpty(r107) == false) goto L27;
        r101.d(null, true);     // Catch: Exception -> L34
        AppCompatSeekBar r108 = r101.f207967f;     // Catch: Exception -> L34
        if (r108 == null) goto L39;
        r108.setProgress(0);     // Catch: Exception -> L34
        goto L39
    L27:
        if (TextUtils.equals("-", r107) == true) goto L43;
        r101.d(Double.valueOf(CastDoubleProtector.parseDouble(r107)), true);     // Catch: Exception -> L34
        r101.e();     // Catch: Exception -> L34
        goto L39
    L43:
        return;
    L7:
        if (r102.f207923c != true) goto L9;
        r103 = true;
    L34:
        e = move-exception;
        tt5.a.d(r101.f207964c, "handleTextChanged exception:" + e.getMessage());
        if (TextUtils.equals("multiple points", ((NumberFormatException) e).getMessage()) == false) goto L38;
        Toast.showFailureText(r101.f207962a, R.string.Doc_Block_NotSupportMultiplePoints);
        goto L39
    L38:
        Toast.showFailureText(r101.f207962a, R.string.Doc_Block_OnlySupportNumber);
        goto L39
    }
}
