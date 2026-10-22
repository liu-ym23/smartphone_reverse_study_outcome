package com.ss.android.bytedcert.video.fragment;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.nova.R;
import com.ss.android.bytedcert.callback.SDKCallBack;
import com.ss.android.bytedcert.dialog.CommonDialog;
import com.ss.android.bytedcert.dialog.controller.video.VideoRecordController;
import com.ss.android.bytedcert.flow.base.ICertFlow;
import com.ss.android.bytedcert.flow.cert.BytedCertFlow;
import com.ss.android.bytedcert.manager.BytedCertManager;
import com.ss.android.bytedcert.net.BDResponse;
import com.ss.android.bytedcert.video.fragment.base.AbsBaseFragment;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.cert.manager.utils.net.CertResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import psa.e;

/* JADX INFO: loaded from: classes34.dex */
public class VideoPlayFragment extends AbsBaseFragment implements WeakHandler.IHandler, View.OnClickListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f407667m = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VideoView f407668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f407669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f407670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f407671i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Bitmap f407672j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public VideoRecordController f407673k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f407674l;

    public class a implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r100, MotionEvent r101) {
            return true;
        }

        public a() {
        }
    }

    public class b implements MediaPlayer.OnPreparedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f407675a;

        public b(VideoPlayFragment r100) {
            this.f407675a = r100;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer r100) {
            float r101 = (r100.getVideoWidth() / r100.getVideoHeight()) / (this.f407675a.f407668f.getWidth() / this.f407675a.f407668f.getHeight());
            if (r101 < 1.0f) goto L5;
            this.f407675a.f407668f.setScaleX(r101);
            return;
        L5:
            this.f407675a.f407668f.setScaleY(1.0f / r101);
        }
    }

    public class c implements MediaPlayer.OnCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f407676a;

        public c(VideoPlayFragment r100) {
            this.f407676a = r100;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer r100) {
            VideoPlayFragment r101 = this.f407676a;
            Bitmap r102 = r101.f407672j;
            if (r102 == null) goto L5;
            r101.f407670h.setImageBitmap(r102);
            this.f407676a.f407670h.setVisibility(0);
        L5:
            this.f407676a.f407669g.setVisibility(0);
        }
    }

    public class d implements SDKCallBack.CommonRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f407677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f407678b;

        public class a implements CommonDialog.OnDialogClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f407679a;

            public a(d r100) {
                this.f407679a = r100;
            }

            @Override // com.ss.android.bytedcert.dialog.CommonDialog.OnDialogClickListener
            public final void onCancel(DialogInterface r100) {
                if (this.f407679a.f407678b.getActivity() == null) goto L6;
                ssa.a r101 = (ssa.a) this.f407679a.f407678b.getActivity();
                VideoPlayFragment r102 = this.f407679a.f407678b;
                Pair<Integer, String> r103 = ErrorConstant.Client.ERROR_VIDEO_RECORD_UPLOAD_FAIL;
                int r104 = VideoPlayFragment.f407667m;
                r102.getClass();
                r101.O(new BDResponse(r103));
                return;
            }

            @Override // com.ss.android.bytedcert.dialog.CommonDialog.OnDialogClickListener
            public final void onConfirm(DialogInterface r100) {
                if (this.f407679a.f407678b.getActivity() == null) goto L5;
                ((ssa.a) this.f407679a.f407678b.getActivity()).showLoading();
                ((ssa.a) this.f407679a.f407678b.getActivity()).j0();
            L5:
                d r101 = this.f407679a;
                VideoPlayFragment r102 = r101.f407678b;
                Map<String, Pair<String, byte[]>> r103 = r101.f407677a;
                int r104 = VideoPlayFragment.f407667m;
                r102.S90(r103);
            }
        }

        @Override // com.ss.android.bytedcert.callback.SDKCallBack.CommonRequestCallback
        public final void onRequestFinish(BDResponse r100) {
            if (r100.success == false) goto L11;
            if (this.f407678b.getActivity() == null) goto L7;
            ((ssa.a) this.f407678b.getActivity()).hideLoading();
        L7:
            VideoPlayFragment r101 = this.f407678b;
            int r102 = VideoPlayFragment.f407667m;
            if (r101.getActivity() == null) goto L14;
            ((ssa.a) r101.getActivity()).O(r100);
            return;
        L14:
            return;
        L11:
            if (this.f407678b.getActivity() == null) goto L16;
            ((ssa.a) this.f407678b.getActivity()).hideLoading();
            ((ssa.a) this.f407678b.getActivity()).r1(this.f407678b.getString(R.string.byted_upload_fail), null, this.f407678b.getString(R.string.byted_exit_veri), this.f407678b.getString(R.string.byted_re_upload), new a(this), -1);
            return;
        }

        public d(VideoPlayFragment r100, Map r101) {
            this.f407678b = r100;
            this.f407677a = r101;
        }
    }

    @Override // com.ss.android.bytedcert.video.fragment.base.AbsBaseFragment
    public final int getContentViewLayoutId() {
        return R.layout.byted_fragment_video_play;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
    }

    @Override // com.ss.android.bytedcert.video.fragment.base.AbsBaseFragment
    public final void initActions(View r100) {
    }

    public VideoPlayFragment() {
        this.f407671i = "";
    }

    @Override // com.ss.android.bytedcert.video.fragment.base.AbsBaseFragment
    public final void initData() {
        if (getArguments() == null) goto L20;
        String r100 = getArguments().getString(BytedCertConstant.IntentKey.FLOW_ID);
        ICertFlow r101 = BytedCertManager.getInstance().getFlow(r100);
        if ((r101 instanceof BytedCertFlow) == false) goto L7;
        this.f407673k = ((BytedCertFlow) r101).getRecordController();
    L7:
        VideoRecordController r102 = this.f407673k;
        if (r102 != null) goto L10;
    L13:
        this.f407705e = true;
        BDResponse r103 = new BDResponse(ErrorConstant.Client.ERROR_VIDEO_RECORD_UN_EXISTS);
        if (getActivity() == null) goto L22;
        ((ssa.a) getActivity()).O(r103);
        return;
    L22:
        return;
    L10:
        if (TextUtils.isEmpty(r102.getVideoPath()) == true) goto L13;
        this.f407671i = this.f407673k.getVideoPath();
        this.f407674l = TextUtils.equals("preview", getArguments().getString(BytedCertConstant.IntentKey.VIEW_TYPE));
    L20:
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L19
        r104.put("upload_type", "video");     // Catch: Exception -> L19
        r104.put(MapController.ITEM_LAYER_TAG, "video");     // Catch: Exception -> L19
        this.f407673k.onEvent(EventConstant.Event.EVENT_UPLOAD_PREVIEW_SHOW, r104);     // Catch: Exception -> L19
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Bitmap r100 = this.f407672j;
        if (r100 == null) goto L6;
        r100.recycle();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.f407668f.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f407669g.setVisibility(0);
        this.f407668f.seekTo(0);
        Bitmap r100 = this.f407672j;
        if (r100 == null) goto L6;
        this.f407670h.setImageBitmap(r100);
        this.f407670h.setVisibility(0);
        return;
    }

    public final void S90(Map<String, Pair<String, byte[]>> r100) {
        psa.a r101 = this.f407673k.getRequestUtils();
        d r102 = new d(this, r100);
        Map<String, String> r103 = this.f407673k.appendCommonRequestParams(null);
        r101.getClass();
        new e(r101, r103, r100, r102).start();
    }

    public final void T90(String r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L5
        r101.put("upload_type", "video");     // Catch: Exception -> L5
        r101.put(MapController.ITEM_LAYER_TAG, "video");     // Catch: Exception -> L5
        r101.put("button", r100);     // Catch: Exception -> L5
        this.f407673k.onEvent(EventConstant.Event.EVENT_UPLOAD_PREVIEW_CLICK, r101);     // Catch: Exception -> L5
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100.getId() != R.id.iv_play) goto L9;
        this.f407669g.setVisibility(8);
        VideoView r101 = this.f407668f;
        if (r101 == null) goto L7;
        r101.start();
    L7:
        this.f407670h.setVisibility(8);
        T90("video_review");
        return;
    L9:
        if (r100.getId() != R.id.bt_upload_video) goto L15;
        if (getActivity() == null) goto L13;
        ((ssa.a) getActivity()).showLoading();
    L13:
        HashMap r102 = new HashMap();
        String r103 = this.f407671i;
        r102.put("video_data", new Pair(r103.substring(r103.lastIndexOf(47) + 1), rsa.d.i(new PolarisFileWrapper(this.f407671i))));
        S90(r102);
        T90(LocationMonitorConst.SUBMIT);
        return;
    L15:
        if (r100.getId() != R.id.bt_restart_record) goto L21;
        rsa.d.g(this.f407671i);
        this.f407673k.saveVideo(null);
        if (getActivity() == null) goto L19;
        ((ssa.a) getActivity()).n0("record");
    L19:
        T90(EventConstant.Value.RETRY);
        return;
    L21:
        if (r100.getId() != R.id.return_back) goto L32;
        if (this.f407674l == false) goto L28;
        BDResponse r104 = new BDResponse(new CertResponse(true));
        if (getActivity() == null) goto L27;
        ((ssa.a) getActivity()).O(r104);
    L27:
        T90("cancel");
        return;
    L28:
        T90(EventConstant.Value.RETRY);
        rsa.d.g(this.f407671i);
        this.f407673k.saveVideo(null);
        if (getActivity() == null) goto L42;
        ((ssa.a) getActivity()).n0("record");
        return;
    L42:
        return;
    L32:
        if (r100.getId() == R.id.fl_video_player) goto L34;
        return;
    L34:
        if (this.f407668f.isPlaying() == false) goto L36;
        this.f407668f.pause();
        this.f407669g.setVisibility(0);
        return;
    L36:
        this.f407668f.start();
        this.f407669g.setVisibility(8);
    }

    @Override // com.ss.android.bytedcert.video.fragment.base.AbsBaseFragment
    public final void initViews(View r100, Bundle r101) {
        this.f407668f = (VideoView) r100.findViewById(R.id.video_play);
        this.f407669g = (ImageView) r100.findViewById(R.id.iv_play);
        ImageView r102 = (ImageView) r100.findViewById(R.id.return_back);
        this.f407670h = (ImageView) r100.findViewById(R.id.video_first_frame);
        Button r103 = (Button) r100.findViewById(R.id.bt_upload_video);
        if (this.f407674l == false) goto L5;
        r103.setVisibility(8);
    L5:
        Button r104 = (Button) r100.findViewById(R.id.bt_restart_record);
        ((ViewGroup) r100.findViewById(R.id.fl_video_player)).setOnClickListener(this);
        RelativeLayout r105 = (RelativeLayout) r100.findViewById(R.id.title_bar);
        ((TextView) r100.findViewById(R.id.tv_prompt_context)).setText(getString(R.string.byted_video_record_check_detail, new Object[]{this.f407673k.getReadContext()}));
        r105.setOnTouchListener(new a());
        Bitmap r106 = VideoRecordController.getThumbBitmap(this.f407671i);
        this.f407672j = r106;
        if (r106 == null) goto L8;
        this.f407670h.setImageBitmap(r106);
        this.f407670h.setVisibility(0);
    L8:
        this.f407668f.setOnPreparedListener(new b(this));
        this.f407668f.setOnCompletionListener(new c(this));
        this.f407668f.setVideoPath(this.f407671i);
        this.f407669g.setOnClickListener(this);
        r103.setOnClickListener(this);
        r102.setOnClickListener(this);
        r104.setOnClickListener(this);
    }
}
