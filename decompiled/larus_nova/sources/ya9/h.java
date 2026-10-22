package ya9;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.flowskill.impl.actionbar.TaskSkillHolder;

/* JADX INFO: loaded from: classes29.dex */
public final class h extends BaseControllerListener<ImageInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f567039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TaskSkillHolder f567040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean[] f567041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f567042d;

    public final void a(boolean r100) {
        int r101 = this.f567039a;
        TaskSkillHolder r102 = this.f567040b;
        if (r101 == r102.f343487l) goto L5;
        return;
    L5:
        boolean[] r103 = this.f567041c;
        r103[this.f567042d] = r100;
        int r104 = r103.length;
        boolean r105 = false;
        int r106 = 0;
    L6:
        if (r106 >= r104) goto L11;
        if (r103[r106] == false) goto L12;
        r106 = r106 + 1;
    L12:
        r102.V3(r105);
        return;
    L11:
        r105 = true;
        goto L12
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onRelease(String r100) {
        a(false);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFailure(String r100, Throwable r101) {
        a(false);
    }

    @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
    public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
        if (((ImageInfo) r101) == null) goto L5;
        boolean r103 = true;
    L6:
        a(r103);
        return;
    L5:
        r103 = false;
        goto L6
    }

    public h(int r100, TaskSkillHolder r101, boolean[] r102, int r103) {
        this.f567039a = r100;
        this.f567040b = r101;
        this.f567041c = r102;
        this.f567042d = r103;
    }
}
