package com.ss.android.lark.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import java.io.Serializable;

/* JADX INFO: loaded from: classes38.dex */
public class CommonPopupRecycleAdapter extends RecyclerView.Adapter<a> {

    public static class ListItem implements Serializable {
        private String base64Img;
        private String iconId;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f444537id;
        private String text;

        public ListItem() {
        }

        public String toString() {
            return "id:" + this.f444537id + ",iconId:" + this.iconId + ",text:" + this.text + ",base64Img:" + this.base64Img + i.f25853b;
        }

        public String getBase64Img() {
            return this.base64Img;
        }

        public String getIconId() {
            return this.iconId;
        }

        public String getId() {
            return this.f444537id;
        }

        public String getText() {
            return this.text;
        }

        public void setBase64Img(String r100) {
            this.base64Img = r100;
        }

        public void setIconId(String r100) {
            this.iconId = r100;
        }

        public void setId(String r100) {
            this.f444537id = r100;
        }

        public void setText(String r100) {
            this.text = r100;
        }
    }

    public static class a extends RecyclerView.ViewHolder {
        public a() {
            throw null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        throw null;
    }

    public static Bitmap y2(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L11;
        return null;
    L11:
        byte[] r101 = Base64.decode(r100, 0);     // Catch: Throwable -> L8
        return BitmapFactory.decodeByteArray(r101, 0, r101.length);
    L8:
        th = move-exception;
        Log.e("stringToBitmap", th.getMessage());
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        a r102 = (a) r100;
        ListItem r103 = (ListItem) ListProtector.get(null, r101);
        if (r103 != null) goto L5;
        return;
    L5:
        String r104 = r103.getBase64Img();
        if (TextUtils.isEmpty(r104) == false) goto L8;
        Bitmap r105 = null;
    L9:
        if (r105 != null) goto L12;
        r102.getClass();
        throw null;
    L12:
        r102.getClass();
        throw null;
    L8:
        r105 = y2(r104);
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        throw null;
    }
}
