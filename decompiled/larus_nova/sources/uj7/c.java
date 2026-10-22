package uj7;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.ug.sdk.luckycat.impl.project.ProjectActivity;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f550413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ProjectActivity f550414b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        String r101 = this.f550413a.getText().toString().trim();
        if (TextUtils.isEmpty(r101) == true) goto L6;
        com.bytedance.ug.sdk.luckycat.impl.utils.u.a().g(BaseHttpRequestInfo.KEY_ABTEST, r101);
        Toast.makeText(this.f550414b, "保存成功", 1).show();
        return;
    }

    public c(ProjectActivity r100, EditText r101) {
        this.f550414b = r100;
        this.f550413a = r101;
    }
}
