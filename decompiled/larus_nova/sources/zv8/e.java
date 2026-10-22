package zv8;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.business.debug.base.register.EntranceGroup;
import com.larus.business.debug.base.register.EntranceType;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f573748a = 0;

    public static final class a {
        @JvmStatic
        public static void a(final e r110) {
            Intrinsics.checkNotNullParameter(r110, "debugEntrance");
            AppHost.Companion r100 = AppHost.f326268a;
            final Activity r101 = r100.a().getCurrentActivity();
            if (r101 == null) goto L32;
            String r102 = CollectionsKt.joinToString$default(r110.e(), ", ", null, null, 0, null, null, 62, null);
            View r103 = r101.getLayoutInflater().inflate(R.layout.larus_debug_entrance_tip_dialog, null);
            if (r103 == null) goto L34;
            boolean r104 = true;
            final AlertDialog r105 = new AlertDialog.Builder(r101).setView(r103).setCancelable(true).show();
            TextView r106 = (TextView) r103.findViewById(R.id.debug_tips_favorite_text);
            ImageView r107 = (ImageView) r103.findViewById(R.id.debug_tips_favorite_icon);
            int r108 = e.f573748a;
            boolean r109 = aw8.c.b(r110);
            if (r109 == false) goto L10;
            int r111 = R.string.larus_debug_entrance_no_favorite;
        L11:
            if (r109 == false) goto L13;
            int r112 = R.drawable.larus_ic_screen_menu_cancel_collect;
        L14:
            if (r106 == null) goto L16;
            r106.setText(r101.getString(r111));
        L16:
            if (r107 == null) goto L18;
            r107.setImageDrawable(AppCompatResources.getDrawable(r101, r112));
        L18:
            TextView r113 = (TextView) r103.findViewById(R.id.debug_tips_dialog_poc);
            if (r113 == null) goto L21;
            r113.setText("Owner：" + r102);
        L21:
            LinearLayout r114 = (LinearLayout) r103.findViewById(R.id.debug_tips_favorite);
            if (r100.isOversea() == true) goto L25;
        L28:
            if (r104 == true) goto L30;
            r114.setVisibility(8);
            return;
        L30:
            r114.setVisibility(0);
            r114.setOnClickListener(new c(r110, r105, r101));
            return;
        L25:
            if (r100.isTestChannel() == true) goto L28;
            r104 = false;
            goto L28
        L13:
            r112 = R.drawable.larus_ic_screen_menu_collect;
            goto L14
        L10:
            r111 = R.string.larus_debug_entrance_favorite;
            goto L11
        L34:
            return;
        }
    }

    static {
    }

    public e() {
    }

    public void a() {
    }

    public abstract EntranceGroup b();

    public abstract String c();

    public abstract EntranceType d();

    public abstract List<String> e();

    public final String toString() {
        return "DebugEntrance(group: " + b() + ", name: " + c() + ", owner: " + CollectionsKt.joinToString$default(e(), null, null, null, 0, null, null, 63, null) + ')';
    }
}
