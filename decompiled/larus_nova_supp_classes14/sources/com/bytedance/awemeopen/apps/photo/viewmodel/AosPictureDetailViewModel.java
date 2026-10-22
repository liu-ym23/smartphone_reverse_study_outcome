package com.bytedance.awemeopen.apps.photo.viewmodel;

import android.app.Application;
import androidx.lifecycle.Observer;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.avatar.AvatarModel;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.feed.preload.aweme.AosAwemePreloadManager;
import com.bytedance.awemeopen.export.api.picturedetail.AosPictureDetailConfig;
import com.bytedance.awemeopen.servicesapi.ui.host.ext.AoUIComponentExtensionService;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fJ0\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016J\u0014\u0010\u001b\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019J\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0014\u0010 \u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019J\u000e\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020!J\u0014\u0010$\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020!0\u0019J\u0006\u0010%\u001a\u00020\fJ\u0006\u0010&\u001a\u00020\tR\u0016\u0010(\u001a\u0004\u0018\u00010'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010*R$\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010+\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u0016078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001c078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00109R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020!078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00109¨\u0006>"}, d2 = {"Lcom/bytedance/awemeopen/apps/photo/viewmodel/AosPictureDetailViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "Lr14/c;", "aweme", "Ls64/b;", "transAwemeToUIComponentInitData", "Lcom/bytedance/awemeopen/export/api/picturedetail/AosPictureDetailConfig;", "getPageConfig", "pictureDetailConfig", "", "initPageConfig", "initAweme", "", "aid", "checkPreloadData", "checkPreloadNoMusicItem", "enterAid", "enterRequestId", "contentScene", "Lh04/e;", "callback", "startServerRefreshSpecified", "Lcom/bytedance/awemeopen/apps/framework/feed/ui/rightbar/avatar/AvatarModel$FollowStatus;", "followStatus", "updateFollowStatus", "Landroidx/lifecycle/Observer;", "observer", "observeFollowStatus", "", UploadTypeInf.COUNT, "setCommentCount", "getCommentCount", "observeCommentCount", "", "isDigg", "changeDiggStatus", "observeDiggStatusChange", "sceneId", "onDestroy", "Lcom/bytedance/awemeopen/servicesapi/ui/host/ext/AoUIComponentExtensionService;", "uiComponentExtensionService", "Lcom/bytedance/awemeopen/servicesapi/ui/host/ext/AoUIComponentExtensionService;", "Lcom/bytedance/awemeopen/export/api/picturedetail/AosPictureDetailConfig;", "Ljava/lang/String;", "getEnterAid", "()Ljava/lang/String;", "setEnterAid", "(Ljava/lang/String;)V", "getEnterRequestId", "setEnterRequestId", "Lr14/c;", "getAweme", "()Lr14/c;", "setAweme", "(Lr14/c;)V", "Ltz3/b;", "followStatusLiveData", "Ltz3/b;", "commentCountLiveData", "diggStatusLiveData", "<init>", "()V", "ao_apps_photo_release"}, k = 1, mv = {1, 7, 1})
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
        public final /* synthetic */ e<c> a;

        public a(e<c> r1) {
            this.a = r1;
        }

        public final void onFail(Exception r3) {
            this.a.a(r3, -1);
        }

        public final void onSuccess(List<c> r3) {
            Intrinsics.checkNotNullParameter(r3, "data");
            this.a.b(r3, false, false);
        }
    }

    public final String sceneId() {
        return "graphic_detail";
    }

    public final long getCommentCount() {
        Long r0 = this.commentCountLiveData.c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.longValue();
    }

    public final void onDestroy() {
        d14.a r0 = b14.a.a;
        b14.a.a(p24.e.class).f();
        b14.a.a(d.class).f();
    }

    public AosPictureDetailViewModel() {
        this.uiComponentExtensionService = j64.a.a(AoUIComponentExtensionService.class);
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

    private final s64.b transAwemeToUIComponentInitData(c r8) {
        ArrayList r0 = new ArrayList();
        List r1 = r8.v();
        if (r1 == null) goto L8;
        Iterator r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        y r3 = (y) r2.next();
        r0.add(new s64.c(r3.b(), r3.c(), r3.d(), r3.a()));
    L8:
        String r4 = r8.c();
        User r9 = r8.f();
        JSONObject r5 = null;
        if (r9 == null) goto L11;
        String r10 = r9.u();
    L12:
        AosPictureDetailConfig r6 = getPageConfig();
        if (r6 == null) goto L16;
        r5 = r6.getHostCommonParams();
    L16:
        return new s64.b(r4, r10, r5, r0);
    L11:
        r10 = null;
        goto L12
    }

    public final void changeDiggStatus(boolean r3) {
        if (Intrinsics.areEqual(this.diggStatusLiveData.c, Boolean.valueOf(r3)) == true) goto L6;
        this.diggStatusLiveData.b(Boolean.valueOf(r3));
        return;
    }

    public final c checkPreloadData(String r2) {
        AosAwemePreloadManager r0 = AosAwemePreloadManager.a;
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return AosAwemePreloadManager.a(r2);
    }

    public final c checkPreloadNoMusicItem(String r3) {
        AosAwemePreloadManager r0 = AosAwemePreloadManager.a;
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        Intrinsics.checkNotNullParameter(r3, "awemeId");
        w34.a r4 = com.bytedance.awemeopen.domain.feed.preload.aweme.d.f.a(r3);
        if (r4 == null) goto L10;
        boolean r1 = true;
        if (r4.a() != true) goto L10;
    L11:
        if (r1 == true) goto L15;
        return null;
    L15:
        return (c) r4.a;
    L10:
        r1 = false;
        goto L11
    }

    public final void initAweme(c r2) {
        Intrinsics.checkNotNullParameter(r2, "aweme");
        this.aweme = r2;
        AoUIComponentExtensionService r0 = this.uiComponentExtensionService;
        if (r0 == null) goto L6;
        transAwemeToUIComponentInitData(r2);
        r0.C0();
        return;
    }

    public final void initPageConfig(AosPictureDetailConfig r2) {
        Intrinsics.checkNotNullParameter(r2, "pictureDetailConfig");
        this.pictureDetailConfig = r2;
        this.enterAid = r2.getEnterAid();
        this.enterRequestId = r2.getEnterRequestId();
    }

    public final void observeCommentCount(Observer<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.commentCountLiveData.a(r2);
    }

    public final void observeDiggStatusChange(Observer<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.diggStatusLiveData.a(r2);
    }

    public final void observeFollowStatus(Observer<AvatarModel.FollowStatus> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.followStatusLiveData.a(r2);
    }

    public final void setAweme(c r1) {
        this.aweme = r1;
    }

    public final void setCommentCount(long r2) {
        this.commentCountLiveData.b(Long.valueOf(r2));
    }

    public final void setEnterAid(String r1) {
        this.enterAid = r1;
    }

    public final void setEnterRequestId(String r1) {
        this.enterRequestId = r1;
    }

    public final void updateFollowStatus(AvatarModel.FollowStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "followStatus");
        this.followStatusLiveData.b(r2);
    }

    public final void startServerRefreshSpecified(String r4, String r5, String r6, e<c> r7) {
        Intrinsics.checkNotNullParameter(r4, "enterAid");
        Intrinsics.checkNotNullParameter(r7, "callback");
        d14.a r0 = b14.a.a;
        d r1 = b14.a.a(d.class);
        Application r2 = getApplication();
        w24.b r3 = new w24.b();
        r3.d = r4;
        r3.f = r5;
        r3.q = r6;
        ArrayList r8 = new ArrayList();
        r8.add(new u24.e());
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r3.n = r8;
        r3.m = "packageFirstBrushData";
        Boolean r9 = Boolean.TRUE;
        r3.u = r9;
        r3.v = r9;
        Unit r10 = Unit.INSTANCE;
        r1.z1(r2, r3, new a(r7));
    }
}
