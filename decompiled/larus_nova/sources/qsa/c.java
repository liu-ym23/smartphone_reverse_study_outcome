package qsa;

import android.view.View;
import com.ss.android.bytedcert.callback.PhotoCallback;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.ocr.OCRManualActivity;
import com.ss.android.cert.manager.constants.ErrorConstant;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OCRManualActivity f534698a;

    public class a implements PhotoCallback.ResultCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f534699a;

        public a(c r100) {
            this.f534699a = r100;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.ss.android.bytedcert.callback.PhotoCallback.ResultCallBack
        public final void onResult(String[] r100, int r101, String r102) {
            if (r101 != 0) goto L4;
            OCRManualActivity r103 = this.f534699a.f534698a;
            String r104 = r100[0];
            int r105 = OCRManualActivity.f407603m;
            p.c(r103.f407606f, r104);
            r103.F1(r104, null);
            return;
        L4:
            OCRManualActivity r106 = this.f534699a.f534698a;
            String r107 = (String) ErrorConstant.Client.ERROR_PICK_PHOTO_ERROR.second;
            int r108 = OCRManualActivity.f407603m;
            r106.H1(r106, r107);
        }
    }

    public c(OCRManualActivity r100) {
        this.f534698a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BytedCertManager.getInstance().mImgType = "from_album";
        p.d(this.f534698a, 3, BytedCertManager.getInstance().mPickCallbackImp, new a(this));
    }
}
