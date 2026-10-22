package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadAlertDialogInfo {
    public boolean mCancelableOnTouchOutside;
    public Context mContext;
    public OnDialogStatusChangedListener mDialogStatusChangedListener;
    public Drawable mIcon;
    public String mMessage;
    public String mNegativeBtnText;
    public String mPositiveBtnText;
    public int mScene;
    public String mTitle;
    public View mView;

    /* JADX INFO: renamed from: com.ss.android.download.api.model.DownloadAlertDialogInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private boolean mCancelableOnTouchOutside;
        private Context mContext;
        private OnDialogStatusChangedListener mDialogStatusChangedListener;
        private Drawable mIcon;
        private String mMessage;
        private String mNegativeBtnText;
        private String mPositiveBtnText;
        public int mScene;
        private String mTitle;
        public View mView;

        public DownloadAlertDialogInfo build() {
            return new DownloadAlertDialogInfo(this, null);
        }

        public Builder(Context r100) {
            this.mContext = r100;
        }

        public static /* synthetic */ Context access$000(Builder r100) {
            return r100.mContext;
        }

        public static /* synthetic */ String access$100(Builder r100) {
            return r100.mTitle;
        }

        public static /* synthetic */ String access$200(Builder r100) {
            return r100.mMessage;
        }

        public static /* synthetic */ String access$300(Builder r100) {
            return r100.mPositiveBtnText;
        }

        public static /* synthetic */ String access$400(Builder r100) {
            return r100.mNegativeBtnText;
        }

        public static /* synthetic */ boolean access$500(Builder r100) {
            return r100.mCancelableOnTouchOutside;
        }

        public static /* synthetic */ Drawable access$600(Builder r100) {
            return r100.mIcon;
        }

        public static /* synthetic */ OnDialogStatusChangedListener access$700(Builder r100) {
            return r100.mDialogStatusChangedListener;
        }

        public Builder setCancelableOnTouchOutside(boolean r100) {
            this.mCancelableOnTouchOutside = r100;
            return this;
        }

        public Builder setDialogStatusChangedListener(OnDialogStatusChangedListener r100) {
            this.mDialogStatusChangedListener = r100;
            return this;
        }

        public Builder setIcon(Drawable r100) {
            this.mIcon = r100;
            return this;
        }

        public Builder setMessage(String r100) {
            this.mMessage = r100;
            return this;
        }

        public Builder setNegativeBtnText(String r100) {
            this.mNegativeBtnText = r100;
            return this;
        }

        public Builder setPositiveBtnText(String r100) {
            this.mPositiveBtnText = r100;
            return this;
        }

        public Builder setScene(int r100) {
            this.mScene = r100;
            return this;
        }

        public Builder setTitle(String r100) {
            this.mTitle = r100;
            return this;
        }

        public Builder setView(View r100) {
            this.mView = r100;
            return this;
        }
    }

    public interface OnDialogStatusChangedListener {
        void onCancel(DialogInterface r100);

        void onNegativeBtnClick(DialogInterface r100);

        void onPositiveBtnClick(DialogInterface r100);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Scene {
        public static final int BACK_INSTALL = 1;
        public static final int CANCEL = 3;
        public static final int OPEN_APP = 2;
        public static final int WEBVIEW_START = 0;
    }

    private DownloadAlertDialogInfo(Builder r100) {
        this.mCancelableOnTouchOutside = true;
        this.mContext = Builder.access$000(r100);
        this.mTitle = Builder.access$100(r100);
        this.mMessage = Builder.access$200(r100);
        this.mPositiveBtnText = Builder.access$300(r100);
        this.mNegativeBtnText = Builder.access$400(r100);
        this.mCancelableOnTouchOutside = Builder.access$500(r100);
        this.mIcon = Builder.access$600(r100);
        this.mDialogStatusChangedListener = Builder.access$700(r100);
        this.mView = r100.mView;
        this.mScene = r100.mScene;
    }

    public /* synthetic */ DownloadAlertDialogInfo(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
