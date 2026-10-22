package hs4;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.bytedance.ee.bear.bitable.ddui.model.StepContentValueItemModel;
import com.bytedance.ee.bear.bitable.ddui.model.StepContentValueModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public abstract class b extends hs4.a {

    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f486966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f486967b;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            b r101 = this.f486966a;
            String r102 = (String) this.f486967b.element;
            if (r100 == null) goto L5;
            String r103 = r100.toString();
        L6:
            r101.c(r102, r103);
            return;
        L5:
            r103 = null;
            goto L6
        }

        public a(b r100, Ref.ObjectRef r101) {
            this.f486966a = r100;
            this.f486967b = r101;
        }
    }

    @Override // hs4.d
    public final void b(StepContentValueModel r100) {
    }

    public abstract EditText d();

    public abstract View e();

    @Override // hs4.d
    public final View getView() {
        return e();
    }

    /* JADX WARN: Type inference failed for: r5v6, types: [T, java.lang.String] */
    @Override // hs4.d
    public final void a(StepContentValueModel r100) {
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        if (r100 == null) goto L5;
        ArrayList<StepContentValueItemModel> r102 = r100.getData();
    L6:
        if (r102 != null) goto L8;
    L13:
        d().addTextChangedListener(new a(this, r101));
        return;
    L8:
        if ((!r102.isEmpty()) == false) goto L13;
        String r103 = ((StepContentValueItemModel) ListProtector.get(r102, 0)).getText();
        if (TextUtils.isEmpty(r103) == true) goto L12;
        d().setText(r103);
        d().requestFocus();
    L12:
        r101.element = ((StepContentValueItemModel) ListProtector.get(r102, 0)).getOnInputChanged();
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    public b(Context r100, com.bytedance.ee.bear.bitable.filter.view.ddui.step.a r101) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r101);
    }
}
