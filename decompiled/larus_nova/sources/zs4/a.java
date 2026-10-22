package zs4;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements i<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f573476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ActionMode f573477b;

    /* JADX INFO: renamed from: zs4.a$a, reason: collision with other inner class name */
    public static final class ActionModeCallbackC8490a extends ActionMode.Callback2 implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActionMode.Callback f573478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Point f573479b;

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
            return this.f573478a.onActionItemClicked(r100, r101);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
            return this.f573478a.onCreateActionMode(r100, r101);
        }

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r100) {
            this.f573478a.onDestroyActionMode(r100);
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
            return this.f573478a.onPrepareActionMode(r100, r101);
        }

        public ActionModeCallbackC8490a(b r100, Rect r101, Point r102) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            Intrinsics.checkNotNullParameter(r101, "contentRect");
            Intrinsics.checkNotNullParameter(r102, "point");
            this.f573478a = r100;
            this.f573479b = r102;
        }

        @Override // android.view.ActionMode.Callback2
        public final void onGetContentRect(ActionMode r100, View r101, Rect r102) {
            if (r101 == null) goto L6;
            if (r102 == null) goto L7;
            Point r103 = this.f573479b;
            int r104 = r103.x;
            int r105 = r103.y;
            r102.set(r104, r105, r104 + 1, r105 + 1);
            return;
        L7:
            return;
        }
    }

    public static final class b implements ActionMode.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<SimpleItemModel> f573480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m f573481b;

        @Override // android.view.ActionMode.Callback
        public final void onDestroyActionMode(ActionMode r100) {
        }

        public b(List<SimpleItemModel> r100, m r101) {
            Intrinsics.checkNotNullParameter(r100, "simpleItems");
            Intrinsics.checkNotNullParameter(r101, "callbackFun");
            this.f573480a = r100;
            this.f573481b = r101;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
            if (r101 == null) goto L13;
            int r102 = r101.getItemId();
            boolean r103 = false;
            if (r102 >= 0) goto L7;
        L9:
            if (r103 == false) goto L13;
            ActionPayload r104 = ((SimpleItemModel) ListProtector.get(this.f573480a, r102)).getClickActionPayload();
            if (r104 == null) goto L13;
            this.f573481b.a(r104);
            goto L13
        L7:
            if (r102 >= this.f573480a.size()) goto L9;
            r103 = true;
        L13:
            if (r100 == null) goto L15;
            r100.finish();
        L15:
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
            if (r101 == null) goto L6;
            r101.clear();
            return true;
        L6:
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
            int r102 = this.f573480a.size();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L7;
            if (r101 == null) goto L6;
            r101.add(769711401, r103, r103, ((SimpleItemModel) ListProtector.get(this.f573480a, r103)).getText());
        L6:
            r103 = r103 + 1;
            goto L3
        L7:
            return true;
        }
    }

    public static final class c {
    }

    static {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f573476a = r100;
    }

    public static List a(JSONArray r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        SimpleItemModel r104 = new SimpleItemModel();
        JSONObject r105 = JSONArrayProtectorUtils.getJSONObject(r100, r103);
        r104.setId(r105.optString("id"));
        r104.setText(JSONObjectProtectorUtils.getString(r105, "text"));
        r104.setClickAction(r105.optString("clickAction"));
        JSONObject r106 = r105.optJSONObject("clickActionPayload");
        if (r106 == null) goto L7;
        ActionPayload r107 = new ActionPayload();
        r107.setId(r106.optString("id"));
        r107.setAction(r106.optString("action"));
        r104.setClickActionPayload(r107);
    L7:
        r101.add(r104);
        r103 = r103 + 1;
        goto L3
    L8:
        return r101;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r110, m r111) {
        String r112 = (String) r110;
        Intrinsics.checkNotNullParameter(r111, "callback");
        if (r112 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L25;
        tt5.a.h("ContextMenuHandler", "showActionMode: " + r112);
        JSONObject r101 = new JSONObject(r112);     // Catch: Throwable -> L20
        JSONObject r113 = JSONObjectProtectorUtils.getJSONObject(r101, "position");     // Catch: Throwable -> L20
        JSONArray r102 = JSONObjectProtectorUtils.getJSONArray(r101, "menus");     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L20
        Rect r103 = new Rect(n.c((float) JSONObjectProtectorUtils.getDouble(r113, "left")), n.c((float) JSONObjectProtectorUtils.getDouble(r113, "top")), n.c((float) JSONObjectProtectorUtils.getDouble(r113, "right")), n.c((float) JSONObjectProtectorUtils.getDouble(r113, "bottom")));     // Catch: Throwable -> L20
        Point r104 = new Point(n.c((float) JSONObjectProtectorUtils.getDouble(r113, "x")), n.c((float) JSONObjectProtectorUtils.getDouble(r113, "y")));     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L20
        List r114 = a(r102);     // Catch: Throwable -> L20
        View r105 = this.f573476a;     // Catch: Throwable -> L20
        ActionMode r106 = this.f573477b;     // Catch: Throwable -> L20
        if (r106 == null) goto L14;
        r106.finish();     // Catch: Throwable -> L20
    L14:
        this.f573477b = null;     // Catch: Throwable -> L20
        b r107 = new b(r114, r111);     // Catch: Throwable -> L20
        if (Build.VERSION.SDK_INT < 23) goto L17;
        ActionMode r115 = r105.startActionMode(new ActionModeCallbackC8490a(r107, r103, r104), 1);     // Catch: Throwable -> L20
    L18:
        this.f573477b = r115;     // Catch: Throwable -> L20
        return;
    L17:
        r115 = r105.startActionMode(r107);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        tt5.a.e("ContextMenuHandler", "showActionMode exception ", th, false);
        return;
    L25:
        return;
    L5:
        if (r112.length() == 0) goto L8;
        r100 = false;
        goto L9
    }
}
