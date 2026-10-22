package com.bytedance.ee.bear.list.move;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.move.api.SpaceMoveToWikiStatusPuller$MoveObj;
import com.bytedance.ee.bear.list.move.api.SpaceMoveToWikiStatusPuller$MoveToWikiStatus;
import com.bytedance.ee.bear.list.move.api.SpaceMoveToWikiStatusPuller$Result;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import dd5.s1;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ Context a;
    public final /* synthetic */ SpaceSelectorBean b;
    public final /* synthetic */ j c;
    public final /* synthetic */ Ref.ObjectRef<ApplyMoveViewModel> d;

    public l(Context r1, SpaceSelectorBean r2, j r3, Ref.ObjectRef<ApplyMoveViewModel> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r5) {
        SpaceMoveToWikiStatusPuller$Result r6 = (SpaceMoveToWikiStatusPuller$Result) r5;
        Intrinsics.checkNotNullParameter(r6, "result");
        int r0 = j.k;
        tt5.a.h("SpaceMoveToWikiCommand", "moveSpace()...status = " + r6);
        Toast.cancelLoading();
        ArrayList<SpaceMoveToWikiStatusPuller$MoveObj> r7 = r6.move_objs;
        SpaceSelectorBean r1 = this.b;
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        T r2 = r8.next();
        if (Intrinsics.areEqual(((SpaceMoveToWikiStatusPuller$MoveObj) r2).obj_token, r1.b) == false) goto L4;
    L9:
        SpaceMoveToWikiStatusPuller$MoveObj r3 = r2;
        if (r3 != null) goto L12;
        Context r9 = this.a;
        Toast.showFailureText(r9, r9.getString(2131887932));
        return;
    L12:
        String r10 = r3.wiki_token;
        int r4 = r3.status;
        if (r4 != SpaceMoveToWikiStatusPuller$MoveToWikiStatus.MOVE_DONE.getStatus()) goto L19;
        Context r11 = this.a;
        Toast.showSuccessText(r11, r11.getString(2131888334));
        s1.a.a.c(this.b.d, this.c.c.d);
        j r12 = this.c;
        ApplyMoveViewModel r13 = (ApplyMoveViewModel) this.d.element;
        Intrinsics.checkNotNull(r10);
        String r14 = r3.obj_token;
        if (r14 != null) goto L17;
        r14 = "";
    L17:
        r12.getClass();
        j.b(r13, true, r10, r14);
        return;
    L19:
        if (r4 != SpaceMoveToWikiStatusPuller$MoveToWikiStatus.ALREADY_EXIST.getStatus()) goto L22;
        Context r15 = this.a;
        Toast.showSuccessText(r15, r15.getString(2131889804));
        j.c(this.c, (ApplyMoveViewModel) this.d.element);
        return;
    L22:
        if (r4 != SpaceMoveToWikiStatusPuller$MoveToWikiStatus.MOVE_FAILED.getStatus()) goto L25;
        Context r16 = this.a;
        Toast.showFailureText(r16, r16.getString(2131889140));
        j.c(this.c, (ApplyMoveViewModel) this.d.element);
        return;
    L25:
        if (r4 != SpaceMoveToWikiStatusPuller$MoveToWikiStatus.MOUNT_EXTEND_LIMIT.getStatus()) goto L28;
        Context r17 = this.a;
        Toast.showFailureText(r17, r17.getString(2131889807));
        j.c(this.c, (ApplyMoveViewModel) this.d.element);
        return;
    L28:
        if (r4 != SpaceMoveToWikiStatusPuller$MoveToWikiStatus.HAVE_NO_PERMISSION.getStatus()) goto L31;
        Context r18 = this.a;
        Toast.showFailureText(r18, r18.getString(2131889141));
        j.c(this.c, (ApplyMoveViewModel) this.d.element);
        return;
    L31:
        if (r4 != SpaceMoveToWikiStatusPuller$MoveToWikiStatus.NOT_SUPPORT_LABEL.getStatus()) goto L33;
        Context r19 = this.a;
        Toast.showFailureText(r19, r19.getString(2131889252));
        j.c(this.c, (ApplyMoveViewModel) this.d.element);
        return;
    L33:
        j.c(this.c, (ApplyMoveViewModel) this.d.element);
        Context r20 = this.a;
        Toast.showFailureText(r20, r20.getString(2131889140));
        return;
    L8:
        r2 = (T) null;
        goto L9
    }
}
