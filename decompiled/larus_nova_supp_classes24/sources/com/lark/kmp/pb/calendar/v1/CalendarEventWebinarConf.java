package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000bR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0014\u0010\u000bR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0016\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventWebinarConf;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventWebinarConf$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventWebinarConf$Builder;Lokio/ByteString;)V", "speaker_can_see_other_speakers", "", "getSpeaker_can_see_other_speakers", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "speaker_can_invite_others", "getSpeaker_can_invite_others", "audience_can_see_other_speakers", "getAudience_can_see_other_speakers", "audience_can_invite_others", "getAudience_can_invite_others", "speaker_can_see_other_audiences", "getSpeaker_can_see_other_audiences", "audience_can_see_other_audiences", "getAudience_can_see_other_audiences", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarEventWebinarConf extends Message<CalendarEventWebinarConf, a> {
    public static final ProtoAdapter<CalendarEventWebinarConf> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Boolean audience_can_invite_others;
    private final Boolean audience_can_see_other_audiences;
    private final Boolean audience_can_see_other_speakers;
    private final Boolean speaker_can_invite_others;
    private final Boolean speaker_can_see_other_audiences;
    private final Boolean speaker_can_see_other_speakers;

    public static final class a extends Message.a<CalendarEventWebinarConf, a> {
        public Boolean d;
        public Boolean e;
        public Boolean f;
        public Boolean g;
        public Boolean h;
        public Boolean i;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new CalendarEventWebinarConf(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CalendarEventWebinarConf> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarEventWebinarConf c(g0 r6) {
            Intrinsics.checkNotNullParameter(r6, "reader");
            a r0 = new a();
            long r1 = r6.c();
        L3:
            int r3 = r6.e();
            if (r3 == (-1)) goto L14;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.i = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L8:
            r0.h = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L9:
            r0.g = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L10:
            r0.f = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L11:
            r0.e = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L12:
            r0.d = (Boolean) ProtoAdapter.g.c(r6);
            goto L3
        L6:
            r6.j(r3);
            Unit r4 = Unit.INSTANCE;
            goto L3
        L14:
            return new CalendarEventWebinarConf(r0, r6.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarEventWebinarConf r5) {
            CalendarEventWebinarConf r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            l r1 = ProtoAdapter.g;
            return (((((r0 + r1.l(1, r6.getSpeaker_can_see_other_speakers())) + r1.l(2, r6.getSpeaker_can_invite_others())) + r1.l(3, r6.getAudience_can_see_other_speakers())) + r1.l(4, r6.getAudience_can_invite_others())) + r1.l(5, r6.getSpeaker_can_see_other_audiences())) + r1.l(6, r6.getAudience_can_see_other_audiences());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CalendarEventWebinarConf r5) {
            CalendarEventWebinarConf r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            l r0 = ProtoAdapter.g;
            r0.i(r4, 1, r6.getSpeaker_can_see_other_speakers());
            r0.i(r4, 2, r6.getSpeaker_can_invite_others());
            r0.i(r4, 3, r6.getAudience_can_see_other_speakers());
            r0.i(r4, 4, r6.getAudience_can_invite_others());
            r0.i(r4, 5, r6.getSpeaker_can_see_other_audiences());
            r0.i(r4, 6, r6.getAudience_can_see_other_audiences());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CalendarEventWebinarConf r5) {
            CalendarEventWebinarConf r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            l r0 = ProtoAdapter.g;
            r0.j(r4, 6, r6.getAudience_can_see_other_audiences());
            r0.j(r4, 5, r6.getSpeaker_can_see_other_audiences());
            r0.j(r4, 4, r6.getAudience_can_invite_others());
            r0.j(r4, 3, r6.getAudience_can_see_other_speakers());
            r0.j(r4, 2, r6.getSpeaker_can_invite_others());
            r0.j(r4, 1, r6.getSpeaker_can_see_other_speakers());
        }

        public b(FieldEncoding r7, KClass<CalendarEventWebinarConf> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventWebinarConf", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarEventWebinarConf(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarEventWebinarConf.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.speaker_can_see_other_speakers;
        r0.e = this.speaker_can_invite_others;
        r0.f = this.audience_can_see_other_speakers;
        r0.g = this.audience_can_invite_others;
        r0.h = this.speaker_can_see_other_audiences;
        r0.i = this.audience_can_see_other_audiences;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarEventWebinarConf.class).getSimpleName() + '@' + hashCode();
    }

    public final Boolean getAudience_can_invite_others() {
        return this.audience_can_invite_others;
    }

    public final Boolean getAudience_can_see_other_audiences() {
        return this.audience_can_see_other_audiences;
    }

    public final Boolean getAudience_can_see_other_speakers() {
        return this.audience_can_see_other_speakers;
    }

    public final Boolean getSpeaker_can_invite_others() {
        return this.speaker_can_invite_others;
    }

    public final Boolean getSpeaker_can_see_other_audiences() {
        return this.speaker_can_see_other_audiences;
    }

    public final Boolean getSpeaker_can_see_other_speakers() {
        return this.speaker_can_see_other_speakers;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarEventWebinarConf(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.speaker_can_see_other_speakers = r2.d;
        this.speaker_can_invite_others = r2.e;
        this.audience_can_see_other_speakers = r2.f;
        this.audience_can_invite_others = r2.g;
        this.speaker_can_see_other_audiences = r2.h;
        this.audience_can_see_other_audiences = r2.i;
    }

    public /* synthetic */ CalendarEventWebinarConf(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
