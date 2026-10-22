package kwb;

import android.view.View;
import android.widget.TextView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.nova.R;
import com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmSubtitleSpeakerAvatarView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f506493e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f506494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmSubtitleSpeakerAvatarView f506495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f506496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f506497d;

    public static final class a {
    }

    static {
    }

    public b(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f506494a = r100;
        View r101 = r100.findViewById(R.id.avatarView);
        if (r101 == null) goto L15;
        this.f506495b = (MmSubtitleSpeakerAvatarView) r101;
        View r102 = r100.findViewById(R.id.nameView);
        if (r102 == null) goto L13;
        this.f506496c = (TextView) r102;
        View r103 = r100.findViewById(R.id.departmentView);
        if (r103 == null) goto L11;
        this.f506497d = (TextView) r103;
        return;
    L11:
        throw new IllegalStateException("Required view not found, id=2131368810, type=".concat(TextView.class.getSimpleName()));
    L13:
        throw new IllegalStateException("Required view not found, id=2131380595, type=".concat(TextView.class.getSimpleName()));
    L15:
        throw new IllegalStateException("Required view not found, id=2131363638, type=MmSubtitleSpeakerAvatarView");
    }
}
