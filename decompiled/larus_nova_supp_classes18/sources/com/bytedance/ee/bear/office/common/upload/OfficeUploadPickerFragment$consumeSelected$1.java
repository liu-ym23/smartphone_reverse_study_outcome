package com.bytedance.ee.bear.office.common.upload;

import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceUploadSelection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OfficeUploadPickerFragment$consumeSelected$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<OfficeSpaceUploadSelection> $selections;
    final /* synthetic */ OfficeUploadPickerFragment this$0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.office.common.upload.OfficeUploadPickerFragment$consumeSelected$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<b.d, Unit> {
        public AnonymousClass1(Object r8) {
            super(1, r8, OfficeUploadPickerFragment.class, "handlePermissionAction", "handlePermissionAction(Lcom/bytedance/ee/bear/office/common/upload/OfficeUploadAvailability$PermissionAction;)V", 0);
        }

        public final void invoke(b.d r3) {
            Intrinsics.checkNotNullParameter(r3, "p0");
            OfficeUploadPickerFragment r0 = (OfficeUploadPickerFragment) ((CallableReference) this).receiver;
            int r1 = OfficeUploadPickerFragment.j;
            FragmentActivity r2 = r0.getActivity();
            if (r2 != null) goto L5;
            tt5.a.k("OfficeUploadPickerFragment", "drop permission action because activity missing after picker callback");
            return;
        L5:
            z.a(r2, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((b.d) r1);
            return Unit.INSTANCE;
        }
    }

    public OfficeUploadPickerFragment$consumeSelected$1(OfficeUploadPickerFragment r1, List<OfficeSpaceUploadSelection> r2) {
        this.this$0 = r1;
        this.$selections = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m327invoke() {
        OfficeUploadPickerFragment r1 = this.this$0;
        g0 r15 = r1.d;
        OfficeUploadActionType r14 = r1.e;
        t r2 = r1.g;
        OfficeUploadPickerFragment.S90(r1);
        if (r15 == null) goto L94;
        if (r14 != null) goto L6;
        return;
    L6:
        if (r2 != null) goto L9;
        tt5.a.k("OfficeUploadPickerFragment", "drop upload selections because guard context missing after picker callback");
        return;
    L9:
        c.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "context");
        b r4 = c.a(r2);
        boolean r5 = r4 instanceof b.a;
        if (r5 == false) goto L74;
        int r3 = h.a;
        List<OfficeSpaceUploadSelection> r6 = this.$selections;
        AnonymousClass1 r7 = new AnonymousClass1(this.this$0);
        Intrinsics.checkNotNullParameter(r6, "selections");
        Intrinsics.checkNotNullParameter(r15, "target");
        Intrinsics.checkNotNullParameter(r14, "actionType");
        StringBuilder r8 = new StringBuilder("submit selections, rawCount=");
        r8.append(r6.size());
        String r13 = ", actionType=";
        r8.append(", actionType=");
        r8.append(r14);
        String r12 = ", target=";
        r8.append(", target=");
        r8.append(h.b(r15));
        String r11 = "OfficeUploadCoordinator";
        tt5.a.h("OfficeUploadCoordinator", r8.toString());
        Intrinsics.checkNotNullParameter(r2, "context");
        b r9 = c.a(r2);
        if ((r9 instanceof b.a) == false) goto L14;
        ArrayList r10 = new ArrayList();
        Iterator<T> r16 = r6.iterator();
    L18:
        int r17 = 0;
        String r18 = ", mime=";
        if (r16.hasNext() == false) goto L26;
        Object r19 = r16.next();
        OfficeSpaceUploadSelection r20 = (OfficeSpaceUploadSelection) r19;
        if (StringsKt.isBlank(r20.getFilePointer()) == false) goto L23;
        tt5.a.k("OfficeUploadCoordinator", "skip blank upload selection, nameLength=" + r20.getDisplayName().length() + ", mime=" + r20.getMimeType());
    L24:
        if (r17 == 0) goto L18;
        r10.add(r19);
        goto L18
    L23:
        r17 = 1;
        goto L24
    L26:
        ArrayList r21 = new ArrayList();
        Iterator r22 = r10.iterator();
    L27:
        int r23 = 2;
        String r24 = null;
        if (r22.hasNext() == false) goto L58;
        Object r25 = r22.next();
        OfficeSpaceUploadSelection r26 = (OfficeSpaceUploadSelection) r25;
        if (r14 != OfficeUploadActionType.MEDIA) goto L52;
        String r110 = r26.getMimeType();
        Iterator r111 = r22;
        if (r110 == null) goto L36;
        boolean r27 = StringsKt.startsWith$default(r110, "image/", false, 2, null);
        boolean r112 = true;
        if (r27 != true) goto L37;
        boolean r113 = true;
    L38:
        if (r113 == true) goto L53;
        String r28 = r26.getMimeType();
        String r114 = r18;
        if (r28 != null) goto L42;
    L44:
        boolean r115 = false;
    L45:
        if (r115 == true) goto L54;
        OfficeUploadFileType.a r29 = OfficeUploadFileType.Companion;
        String r30 = r26.getDisplayName();
        r29.getClass();
        if (OfficeUploadFileType.a.a(r30) == OfficeUploadFileType.IMAGE) goto L54;
        if (OfficeUploadFileType.a.a(r26.getDisplayName()) == OfficeUploadFileType.VIDEO) goto L54;
        boolean r116 = false;
    L55:
        if (r116 == false) goto L57;
        r21.add(r25);
    L57:
        r22 = r111;
        r18 = r114;
    L54:
        r116 = true;
        goto L55
    L42:
        if (StringsKt.startsWith$default(r28, "video/", false, 2, null) != r112) goto L44;
        r115 = true;
    L53:
        r114 = r18;
    L37:
        r113 = false;
        goto L38
    L36:
        r112 = true;
        goto L37
    L52:
        r111 = r22;
        goto L53
    L58:
        String r117 = r18;
        Iterator r118 = r21.iterator();
    L60:
        if (r118.hasNext() == false) goto L71;
        OfficeSpaceUploadSelection r31 = (OfficeSpaceUploadSelection) r118.next();
        int r119 = r17 + 1;
        String r32 = UUID.randomUUID().toString();
        String r33 = r31.getFilePointer();
        boolean r34 = r31.isFileUseUri();
        String r35 = r31.getDisplayName();
        if (StringsKt.isBlank(r35) == false) goto L70;
        r35 = StringsKt.substringAfterLast$default(r31.getFilePointer(), '/', r24, r23, r24);
        if ((!StringsKt.isBlank(r35)) == true) goto L67;
        r35 = r24;
    L67:
        if (r35 != null) goto L70;
        r35 = eu5.b.a.getString(2131888008);
    L70:
        String r210 = r117;
        String r211 = r11;
        String r212 = r12;
        g0 r120 = r15;
        final h0 r36 = new h0(r32, null, r33, r34, r35, r31.getMimeType(), r31.getSize(), null, r15, null, null, null, 65154);
        StringBuilder r37 = new StringBuilder("submit upload task, localId=");
        r37.append(r36.a);
        r37.append(r212);
        r37.append(h.b(r120));
        r37.append(", isFileUseUri=");
        r37.append(r36.d);
        r37.append(", pointer=");
        String r38 = r36.c;
        r37.append("hash=" + r38.hashCode() + ", length=" + r38.length() + ", ext=" + StringsKt.substringAfterLast(r38, '.', ""));
        r37.append(", nameLength=");
        r37.append(r36.e.length());
        r37.append(", totalBytes=");
        r37.append(r36.g);
        r37.append(r210);
        r37.append(r36.f);
        tt5.a.h(r211, r37.toString());
        Handler r39 = OfficeUploadStore.a;
        Intrinsics.checkNotNullParameter(r36, "task");
        OfficeUploadStore.e(new OfficeUploadStore$addTask$1(r36));
        k.a.getClass();
        Intrinsics.checkNotNullParameter(r36, "task");
        k.b.execute(new n(r36));
        r12 = r212;
        r11 = r211;
        r15 = r120;
        r17 = r119;
        r24 = r24;
        r13 = r13;
        r14 = r14;
        r23 = 2;
        r117 = r210;
        goto L60
    L71:
        String r40 = r11;
        String r310 = r13;
        OfficeUploadActionType r311 = r14;
        if (r17 == r6.size()) goto L110;
        tt5.a.k(r40, "some selections filtered, rawCount=" + r6.size() + ", acceptedCount=" + r17 + r310 + r311);
        return;
    L110:
        return;
    L14:
        if ((r9 instanceof b.d) == false) goto L16;
        r7.invoke(r9);
        tt5.a.k("OfficeUploadCoordinator", "drop upload selections before start, actionType=" + r14 + ", availability=" + h.a(r9));
        return;
    L16:
        tt5.a.k("OfficeUploadCoordinator", "drop upload selections before start, actionType=" + r14 + ", availability=" + h.a(r9));
        return;
    L74:
        boolean r41 = r4 instanceof b.d;
        if (r41 == false) goto L80;
        b.d r42 = (b.d) r4;
        FragmentActivity r43 = this.this$0.getActivity();
        if (r43 != null) goto L79;
        tt5.a.k("OfficeUploadPickerFragment", "drop permission action because activity missing after picker callback");
        return;
    L79:
        z.a(r43, r42);
        return;
    L80:
        StringBuilder r44 = new StringBuilder("drop upload selections after picker callback, availability=");
        this.this$0.getClass();
        if (r5 == false) goto L84;
        String r45 = "available";
    L91:
        r44.append(r45);
        tt5.a.k("OfficeUploadPickerFragment", r44.toString());
        return;
    L84:
        if ((r4 instanceof b.c) == false) goto L87;
        r45 = "hidden:" + ((b.c) r4).a.name();
        goto L91
    L87:
        if ((r4 instanceof b.C0131b) == false) goto L89;
        r45 = "disabled:" + ((b.C0131b) r4).a.name();
        goto L91
    L89:
        if (r41 == false) goto L93;
        r45 = "permission_action:" + ((b.d) r4).a.getDenySource().getUiType();
        goto L91
    L93:
        throw new NoWhenBranchMatchedException();
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m327invoke();
        return Unit.INSTANCE;
    }
}
