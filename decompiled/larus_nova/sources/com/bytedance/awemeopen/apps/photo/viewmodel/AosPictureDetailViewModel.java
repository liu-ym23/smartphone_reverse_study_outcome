package com.bytedance.awemeopen.apps.photo.viewmodel;

import android.app.Application;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar.AvatarModel;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.feed.preload.aweme.AosAwemePreloadManager;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import com.bytedance.awemeopen.servicesapi.ui.host.ext.AoUIComponentExtensionService;
import com.larus.bmhome.share.panel.ShareChannel;
import h04.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r14.c;
import r14.y;
import tz3.b;
import w24.d;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ0\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016J\u0014\u0010\u001b\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019J\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0014\u0010 \u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019J\u000e\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!J\u0014\u0010$\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020!0\u0019J\u0006\u0010%\u001a\u00020\fJ\u0006\u0010&\u001a\u00020\tR\u0016\u0010(\u001a\u0004\u0018\u00010'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010*R$\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010+\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u0016078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001c078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00109R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020!078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00109¨\u0006>"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/viewmodel/AosPictureDetailViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "Lr14/c;", ShareChannel.DOUYIN, "Ls64/b;", "transAwemeToUIComponentInitData", "Lcom/bytedance/awemeopen/export/api/picturedetail/AosPictureDetailConfig;", "getPageConfig", "pictureDetailConfig", "", "initPageConfig", "initAweme", "", "aid", "checkPreloadData", "checkPreloadNoMusicItem", "enterAid", "enterRequestId", "contentScene", "Lh04/e;", "callback", "startServerRefreshSpecified", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/rightbar/avatar/AvatarModel$FollowStatus;", "followStatus", "updateFollowStatus", "Landroidx/lifecycle/Observer;", "observer", "observeFollowStatus", "", "count", "setCommentCount", "getCommentCount", "observeCommentCount", "", "isDigg", "changeDiggStatus", "observeDiggStatusChange", "sceneId", LiveCommonConstants.REASON_ON_DEDTROY, "Lcom/bytedance/awemeopen/servicesapi/ui/host/ext/AoUIComponentExtensionService;", "uiComponentExtensionService", "Lcom/bytedance/awemeopen/servicesapi/ui/host/ext/AoUIComponentExtensionService;", "Lcom/bytedance/awemeopen/export/api/picturedetail/AosPictureDetailConfig;", "Ljava/lang/String;", "getEnterAid", "()Ljava/lang/String;", "setEnterAid", "(Ljava/lang/String;)V", "getEnterRequestId", "setEnterRequestId", "Lr14/c;", "getAweme", "()Lr14/c;", "setAweme", "(Lr14/c;)V", "Ltz3/b;", "followStatusLiveData", "Ltz3/b;", "commentCountLiveData", "diggStatusLiveData", "<init>", "()V", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
public final class AosPictureDetailViewModel extends AosViewModel {
    private c aweme;
    private final b<Long> commentCountLiveData;
    private final b<Boolean> diggStatusLiveData;
    private String enterAid;
    private String enterRequestId;
    private final b<AvatarModel.FollowStatus> followStatusLiveData;
    private AosPictureDetailConfig pictureDetailConfig;
    private final AoUIComponentExtensionService uiComponentExtensionService;

    public static final class a implements r34.b<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e<c> f198069a;

        public a(e<c> r100) {
            this.f198069a = r100;
        }

        @Override // r34.b
        public final void onFail(Exception r100) {
            this.f198069a.a(r100, -1);
        }

        @Override // r34.b
        public final void onSuccess(List<? extends c> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f198069a.b(r100, false, false);
        }
    }

    public final String sceneId() {
        return "graphic_detail";
    }

    public final long getCommentCount() {
        Long r100 = this.commentCountLiveData.f548046c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.longValue();
    }

    public final void onDestroy() {
        d14.a r100 = b14.a.f16924a;
        ((p24.e) b14.a.a(p24.e.class)).f();
        ((d) b14.a.a(d.class)).f();
    }

    public AosPictureDetailViewModel() {
        this.uiComponentExtensionService = (AoUIComponentExtensionService) j64.a.a(AoUIComponentExtensionService.class);
        this.followStatusLiveData = new b();
        this.commentCountLiveData = new b();
        this.diggStatusLiveData = new b();
    }

    public final c getAweme() {
        return this.aweme;
    }

    public final String getEnterAid() {
        return this.enterAid;
    }

    public final String getEnterRequestId() {
        return this.enterRequestId;
    }

    public final AosPictureDetailConfig getPageConfig() {
        return this.pictureDetailConfig;
    }

    private final s64.b transAwemeToUIComponentInitData(c r100) {
        ArrayList r101 = new ArrayList();
        List<y> r102 = r100.v();
        if (r102 == null) goto L8;
        Iterator<T> r103 = r102.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        y r104 = (y) r103.next();
        r101.add(new s64.c(r104.b(), r104.c(), r104.d(), r104.a()));
    L8:
        String r105 = r100.c();
        User r106 = r100.f();
        JSONObject r107 = null;
        if (r106 == null) goto L11;
        String r108 = r106.u();
    L12:
        AosPictureDetailConfig r109 = getPageConfig();
        if (r109 == null) goto L16;
        r107 = r109.getHostCommonParams();
    L16:
        return new s64.b(r105, r108, r107, r101);
    L11:
        r108 = null;
        goto L12
    }

    public final void changeDiggStatus(boolean r100) {
        if (Intrinsics.areEqual(this.diggStatusLiveData.f548046c, Boolean.valueOf(r100)) == true) goto L6;
        this.diggStatusLiveData.b(Boolean.valueOf(r100));
        return;
    }

    public final c checkPreloadData(String r100) {
        AosAwemePreloadManager r101 = AosAwemePreloadManager.f198326a;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return AosAwemePreloadManager.a(r100);
    }

    public final c checkPreloadNoMusicItem(String r100) {
        AosAwemePreloadManager r101 = AosAwemePreloadManager.f198326a;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Intrinsics.checkNotNullParameter(r100, "awemeId");
        w34.a<c> r102 = com.bytedance.awemeopen.domain.feed.preload.aweme.d.f198343f.a(r100);
        if (r102 == null) goto L10;
        boolean r103 = true;
        if (r102.a() != true) goto L10;
    L11:
        if (r103 == true) goto L15;
        return null;
    L15:
        return r102.f558144a;
    L10:
        r103 = false;
        goto L11
    }

    public final void initAweme(c r100) {
        Intrinsics.checkNotNullParameter(r100, ShareChannel.DOUYIN);
        this.aweme = r100;
        AoUIComponentExtensionService r101 = this.uiComponentExtensionService;
        if (r101 == null) goto L6;
        transAwemeToUIComponentInitData(r100);
        r101.C0();
        return;
    }

    public final void initPageConfig(AosPictureDetailConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "pictureDetailConfig");
        this.pictureDetailConfig = r100;
        this.enterAid = r100.getEnterAid();
        this.enterRequestId = r100.getEnterRequestId();
    }

    public final void observeCommentCount(Observer<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.commentCountLiveData.a(r100);
    }

    public final void observeDiggStatusChange(Observer<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.diggStatusLiveData.a(r100);
    }

    public final void observeFollowStatus(Observer<AvatarModel.FollowStatus> r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.followStatusLiveData.a(r100);
    }

    public final void setAweme(c r100) {
        this.aweme = r100;
    }

    public final void setCommentCount(long r100) {
        this.commentCountLiveData.b(Long.valueOf(r100));
    }

    public final void setEnterAid(String r100) {
        this.enterAid = r100;
    }

    public final void setEnterRequestId(String r100) {
        this.enterRequestId = r100;
    }

    public final void updateFollowStatus(AvatarModel.FollowStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "followStatus");
        this.followStatusLiveData.b(r100);
    }

    public final void startServerRefreshSpecified(String r100, String r101, String r102, e<c> r103) {
        Intrinsics.checkNotNullParameter(r100, "enterAid");
        Intrinsics.checkNotNullParameter(r103, "callback");
        d14.a r104 = b14.a.f16924a;
        d r105 = (d) b14.a.a(d.class);
        Application r106 = getApplication();
        w24.b r107 = new w24.b();
        r107.f557998d = r100;
        r107.f558000f = r101;
        r107.f558011q = r102;
        ArrayList r108 = new ArrayList();
        r108.add(new u24.e());
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r107.f558008n = r108;
        r107.f558007m = "packageFirstBrushData";
        Boolean r109 = Boolean.TRUE;
        r107.f558015u = r109;
        r107.f558016v = r109;
        Unit r110 = Unit.INSTANCE;
        r105.z1(r106, r107, new a(r103));
    }
}
