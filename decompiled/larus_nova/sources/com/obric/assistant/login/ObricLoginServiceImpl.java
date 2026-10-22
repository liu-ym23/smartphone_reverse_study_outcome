package com.obric.assistant.login;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.login.impl.loginfragment.u0;
import com.larus.nova.R;
import com.obric.assistant.spi.login.IObricLoginService;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J<\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/login/ObricLoginServiceImpl;", "Lcom/obric/assistant/spi/login/IObricLoginService;", "<init>", "()V", "isNotObricLogin", "", "setupWelcomeContent", "", "welcomeStub", "Landroid/view/ViewStub;", "viewsToHide", "", "Landroid/view/View;", "animatorTitle", "animatorTitleBottomAnchor", "onWelcomePrimaryClick", "Lkotlin/Function0;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLoginServiceImpl implements IObricLoginService {
    public ObricLoginServiceImpl() {
    }

    @Override // com.obric.assistant.spi.login.IObricLoginService
    public final boolean b() {
        return false;
    }

    @Override // com.obric.assistant.spi.login.IObricLoginService
    public final void a(ViewStub r100, List r101, SimpleDraweeView r102, View r103, final u0 r104) {
        Intrinsics.checkNotNullParameter(r100, "welcomeStub");
        Intrinsics.checkNotNullParameter(r101, "viewsToHide");
        Intrinsics.checkNotNullParameter(r102, "animatorTitle");
        Intrinsics.checkNotNullParameter(r103, "animatorTitleBottomAnchor");
        Intrinsics.checkNotNullParameter(r104, "onWelcomePrimaryClick");
        Iterator r105 = r101.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        ((View) r105.next()).setVisibility(8);
        goto L4
    L6:
        ViewGroup.LayoutParams r106 = r102.getLayoutParams();
        if ((r106 instanceof ConstraintLayout.LayoutParams) == false) goto L9;
        ConstraintLayout.LayoutParams r107 = (ConstraintLayout.LayoutParams) r106;
    L10:
        if (r107 == null) goto L12;
        ((ViewGroup.MarginLayoutParams) r107).topMargin = r102.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_152, null, R.dimen.larus_dp_152));
        r107.bottomToTop = r103.getId();
        r102.setLayoutParams(r107);
    L12:
        r100.setLayoutResource(R.layout.obric_welcome_content_page);
        View r108 = r100.inflate();
        int r109 = R.id.welcome_app_name;
        if (((TextView) ViewBindings.findChildViewById(r108, R.id.welcome_app_name)) == null) goto L21;
        r109 = R.id.welcome_primary_button;
        Button r110 = (Button) ViewBindings.findChildViewById(r108, R.id.welcome_primary_button);
        if (r110 == null) goto L21;
        r109 = R.id.welcome_title;
        if (((TextView) ViewBindings.findChildViewById(r108, R.id.welcome_title)) == null) goto L21;
        ConstraintLayout r111 = (ConstraintLayout) r108;
        r110.setOnClickListener(new y(r104));
        return;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r108.getResources().getResourceName(r109)));
    L9:
        r107 = null;
        goto L10
    }
}
