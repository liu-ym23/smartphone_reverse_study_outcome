package r29;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class g implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f535800a;

    public /* synthetic */ g(Context r100) {
        this.f535800a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        View r100 = LayoutInflater.from(this.f535800a).inflate(R.layout.larus_community_creation_list_empty_layout, null, false);
        int r101 = R.id.iv_empty;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.iv_empty)) == null) goto L9;
        r101 = R.id.tv_empty;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.tv_empty)) == null) goto L9;
        return (ConstraintLayout) r100;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
