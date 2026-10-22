package com.larus.bmhome.chat.component.bottom.core;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.ViewGroup;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.MultiAttachmentInfo;
import com.larus.bmhome.chat.adapter.MessageModifyMode;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.taskskill.SkillComponent;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.platform.api.FlowDriveFileSendInfo;
import com.larus.platform.model.EditPos;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.model.action.SuggestedAction;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public interface ICoreInputAbility extends m1a.a {
    public static final a A1 = null;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$MessageExtMap;", "Landroid/os/Parcelable;", "extMap", "", "", "<init>", "(Ljava/util/Map;)V", "getExtMap", "()Ljava/util/Map;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MessageExtMap implements Parcelable {
        public static final Parcelable.Creator<MessageExtMap> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f298403a;

        public static final class a implements Parcelable.Creator<MessageExtMap> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final MessageExtMap createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                int r101 = r100.readInt();
                LinkedHashMap r102 = new LinkedHashMap(r101);
                int r103 = 0;
            L3:
                if (r103 == r101) goto L6;
                r102.put(r100.readString(), r100.readString());
                r103 = r103 + 1;
                goto L3
            L6:
                return new MessageExtMap(r102);
            }

            @Override // android.os.Parcelable.Creator
            public final MessageExtMap[] newArray(int r100) {
                return new MessageExtMap[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof MessageExtMap) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f298403a, ((MessageExtMap) r100).f298403a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f298403a.hashCode();
        }

        public final String toString() {
            return "MessageExtMap(extMap=" + this.f298403a + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            Map<String, String> r102 = this.f298403a;
            r100.writeInt(r102.size());
            Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            Map.Entry<String, String> r104 = r103.next();
            r100.writeString(r104.getKey());
            r100.writeString(r104.getValue());
            goto L4
        }

        public MessageExtMap(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "extMap");
            this.f298403a = r100;
        }
    }

    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\bK\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+\u0012\u0018\b\u0002\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f\u0012\u0018\b\u0002\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/¢\u0006\u0004\b0\u00101J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0017\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u0010\u0010\\\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010=J\u0010\u0010]\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010=J\t\u0010^\u001a\u00020\u0011HÆ\u0003J\t\u0010_\u001a\u00020\u000eHÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u000eHÆ\u0003J\t\u0010b\u001a\u00020\u000eHÆ\u0003J\t\u0010c\u001a\u00020\u000eHÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u000eHÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\u0017\u0010j\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010=J\u000b\u0010p\u001a\u0004\u0018\u00010&HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010(HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010+HÆ\u0003J\u0019\u0010t\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\fHÆ\u0003J\u0019\u0010u\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\fHÆ\u0003J\u0010\u0010v\u001a\u0004\u0018\u00010/HÆ\u0003¢\u0006\u0002\u0010TJÀ\u0003\u0010w\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u000e2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u00032\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\u0018\b\u0002\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\u0018\b\u0002\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/HÆ\u0001¢\u0006\u0002\u0010xJ\u0013\u0010y\u001a\u00020\u000e2\b\u0010z\u001a\u0004\u0018\u00010{HÖ\u0003J\t\u0010|\u001a\u00020\u0011HÖ\u0001J\t\u0010}\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010>\u001a\u0004\b\r\u0010=R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010>\u001a\u0004\b\u000f\u0010=R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u00103R\u0011\u0010\u0014\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bD\u0010BR\u0011\u0010\u0015\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010BR\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010BR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u00103R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u00103R\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00103R\u001e\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u00103R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u00103R\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u00103R\u0015\u0010$\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010>\u001a\u0004\bM\u0010=R\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0013\u0010'\u001a\u0004\u0018\u00010(¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u0013\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u00103R\u0012\u0010*\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R \u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R \u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0015\u0010.\u001a\u0004\u0018\u00010/¢\u0006\n\n\u0002\u0010U\u001a\u0004\bS\u0010T¨\u0006~"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "Ljava/io/Serializable;", "content", "", "hint", SlashMentionConfig.MENTION_CONTENT_ATTACHMENT, "Lcom/larus/bmhome/view/AttachmentInfo;", "multiAttachment", "Lcom/larus/bmhome/chat/MultiAttachmentInfo;", "referenceInfo", "Lcom/larus/im/bean/message/ReferenceInfo;", "actionBarInstructionMap", "", "isShowFullInputBox", "", "isUseFullInputBox", "actionInstruction", "", "localIntercepted", "localInterceptInfo", "textFromAudio", "isReedit", "isInquiryText", "selectionTextAction", "lyricCreateType", "attachmentLocalMsgIds", "", "textLocalMsgId", "clearInputContent", "enterMethod", "messageExt", "suggestedAction", "Lcom/larus/platform/model/action/SuggestedAction;", "scene", "txtScene", "previousPage", "voiceMixInput", "customMultiAttachment", "Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;", "driveFileSendInfo", "Lcom/larus/platform/api/FlowDriveFileSendInfo;", "creationSendTraceId", "chatPageContext", "Lcom/larus/bmhome/chat/bean/ChatPageContext;", "fileForceTraceMap", "textForceTraceMap", "sendClickTimestamp", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/view/AttachmentInfo;Lcom/larus/bmhome/chat/MultiAttachmentInfo;Lcom/larus/im/bean/message/ReferenceInfo;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;IZLjava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Lcom/larus/platform/model/action/SuggestedAction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;Lcom/larus/platform/api/FlowDriveFileSendInfo;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/ChatPageContext;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;)V", "getContent", "()Ljava/lang/String;", "getHint", "getAttachment", "()Lcom/larus/bmhome/view/AttachmentInfo;", "getMultiAttachment", "()Lcom/larus/bmhome/chat/MultiAttachmentInfo;", "getReferenceInfo", "()Lcom/larus/im/bean/message/ReferenceInfo;", "getActionBarInstructionMap", "()Ljava/util/Map;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getActionInstruction", "()I", "getLocalIntercepted", "()Z", "getLocalInterceptInfo", "getTextFromAudio", "getSelectionTextAction", "getLyricCreateType", "getEnterMethod", "getSuggestedAction", "()Lcom/larus/platform/model/action/SuggestedAction;", "getScene", "getTxtScene", "getPreviousPage", "getVoiceMixInput", "getCustomMultiAttachment", "()Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;", "getDriveFileSendInfo", "()Lcom/larus/platform/api/FlowDriveFileSendInfo;", "getCreationSendTraceId", "getSendClickTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/view/AttachmentInfo;Lcom/larus/bmhome/chat/MultiAttachmentInfo;Lcom/larus/im/bean/message/ReferenceInfo;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/Boolean;IZLjava/lang/String;ZZZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Ljava/util/Map;Lcom/larus/platform/model/action/SuggestedAction;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;Lcom/larus/platform/api/FlowDriveFileSendInfo;Ljava/lang/String;Lcom/larus/bmhome/chat/bean/ChatPageContext;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;)Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$OnSendParams;", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OnSendParams implements Serializable {
        private final Map<String, String> actionBarInstructionMap;
        private final int actionInstruction;
        private final AttachmentInfo attachment;
        public final List<String> attachmentLocalMsgIds;
        public final ChatPageContext chatPageContext;
        public final boolean clearInputContent;
        private final String content;
        private final String creationSendTraceId;
        private final CustomMultiAttachmentInfo customMultiAttachment;
        private final FlowDriveFileSendInfo driveFileSendInfo;
        private final String enterMethod;
        public final Map<String, String> fileForceTraceMap;
        private final String hint;
        private final boolean isInquiryText;
        private final boolean isReedit;
        private final Boolean isShowFullInputBox;
        private final Boolean isUseFullInputBox;
        private final String localInterceptInfo;
        private final boolean localIntercepted;
        private final String lyricCreateType;
        public final Map<String, String> messageExt;
        private final MultiAttachmentInfo multiAttachment;
        private final String previousPage;
        private final ReferenceInfo referenceInfo;
        private final String scene;
        private final String selectionTextAction;
        private final Long sendClickTimestamp;
        private final SuggestedAction suggestedAction;
        public final Map<String, String> textForceTraceMap;
        private final boolean textFromAudio;
        public final String textLocalMsgId;
        private final String txtScene;
        private final Boolean voiceMixInput;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ OnSendParams copy$default(OnSendParams r110, String r111, String r112, AttachmentInfo r210, MultiAttachmentInfo r211, ReferenceInfo r212, Map r213, Boolean r214, Boolean r215, int r216, boolean r217, String r218, boolean r219, boolean r310, boolean r311, String r312, String r313, List r314, String r315, boolean r316, String r317, Map r318, SuggestedAction r319, String r410, String r411, String r412, Boolean r413, CustomMultiAttachmentInfo r414, FlowDriveFileSendInfo r415, String r416, ChatPageContext r417, Map r418, Map r419, Long r510, int r511, int r512, Object r513) {
            if ((r511 & 1) == 0) goto L5;
            String r100 = r110.content;
        L7:
            if ((r511 & 2) == 0) goto L9;
            String r101 = r110.hint;
        L11:
            if ((r511 & 4) == 0) goto L13;
            AttachmentInfo r102 = r110.attachment;
        L15:
            if ((r511 & 8) == 0) goto L17;
            MultiAttachmentInfo r103 = r110.multiAttachment;
        L19:
            if ((r511 & 16) == 0) goto L21;
            ReferenceInfo r104 = r110.referenceInfo;
        L23:
            if ((r511 & 32) == 0) goto L25;
            Map r105 = r110.actionBarInstructionMap;
        L27:
            if ((r511 & 64) == 0) goto L29;
            Boolean r106 = r110.isShowFullInputBox;
        L31:
            if ((r511 & 128) == 0) goto L33;
            Boolean r107 = r110.isUseFullInputBox;
        L35:
            if ((r511 & 256) == 0) goto L37;
            int r113 = r110.actionInstruction;
        L39:
            if ((r511 & 512) == 0) goto L41;
            boolean r114 = r110.localIntercepted;
        L43:
            if ((r511 & 1024) == 0) goto L45;
            String r115 = r110.localInterceptInfo;
        L47:
            if ((r511 & 2048) == 0) goto L49;
            boolean r116 = r110.textFromAudio;
        L51:
            if ((r511 & 4096) == 0) goto L53;
            boolean r117 = r110.isReedit;
        L55:
            if ((r511 & 8192) == 0) goto L57;
            boolean r118 = r110.isInquiryText;
        L58:
            boolean r320 = r118;
            if ((r511 & 16384) == 0) goto L61;
            String r119 = r110.selectionTextAction;
        L62:
            String r321 = r119;
            if ((r511 & 32768) == 0) goto L65;
            String r120 = r110.lyricCreateType;
        L66:
            String r322 = r120;
            if ((r511 & 65536) == 0) goto L69;
            List r121 = r110.attachmentLocalMsgIds;
        L70:
            List r323 = r121;
            if ((r511 & 131072) == 0) goto L73;
            String r122 = r110.textLocalMsgId;
        L74:
            String r324 = r122;
            if ((r511 & 262144) == 0) goto L77;
            boolean r123 = r110.clearInputContent;
        L78:
            boolean r325 = r123;
            if ((r511 & 524288) == 0) goto L81;
            String r124 = r110.enterMethod;
        L82:
            String r326 = r124;
            if ((r511 & 1048576) == 0) goto L85;
            Map r125 = r110.messageExt;
        L86:
            Map r327 = r125;
            if ((r511 & 2097152) == 0) goto L89;
            SuggestedAction r126 = r110.suggestedAction;
        L90:
            SuggestedAction r328 = r126;
            if ((r511 & 4194304) == 0) goto L93;
            String r127 = r110.scene;
        L94:
            String r420 = r127;
            if ((r511 & 8388608) == 0) goto L97;
            String r128 = r110.txtScene;
        L98:
            String r421 = r128;
            if ((r511 & 16777216) == 0) goto L101;
            String r129 = r110.previousPage;
        L102:
            String r422 = r129;
            if ((r511 & 33554432) == 0) goto L105;
            Boolean r130 = r110.voiceMixInput;
        L106:
            Boolean r423 = r130;
            if ((r511 & 67108864) == 0) goto L109;
            CustomMultiAttachmentInfo r131 = r110.customMultiAttachment;
        L110:
            CustomMultiAttachmentInfo r424 = r131;
            if ((r511 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
            FlowDriveFileSendInfo r132 = r110.driveFileSendInfo;
        L114:
            FlowDriveFileSendInfo r425 = r132;
            if ((r511 & 268435456) == 0) goto L117;
            String r133 = r110.creationSendTraceId;
        L118:
            String r426 = r133;
            if ((r511 & 536870912) == 0) goto L121;
            ChatPageContext r134 = r110.chatPageContext;
        L122:
            ChatPageContext r427 = r134;
            if ((r511 & 1073741824) == 0) goto L125;
            Map r135 = r110.fileForceTraceMap;
        L127:
            if ((r511 & Integer.MIN_VALUE) == 0) goto L129;
            Map r108 = r110.textForceTraceMap;
        L130:
            Map r428 = r108;
            if ((r512 & 1) == 0) goto L133;
            Long r109 = r110.sendClickTimestamp;
        L135:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r426, r427, r135, r428, r109);
        L133:
            r109 = r510;
            goto L135
        L129:
            r108 = r419;
            goto L130
        L125:
            r135 = r418;
            goto L127
        L121:
            r134 = r417;
            goto L122
        L117:
            r133 = r416;
            goto L118
        L113:
            r132 = r415;
            goto L114
        L109:
            r131 = r414;
            goto L110
        L105:
            r130 = r413;
            goto L106
        L101:
            r129 = r412;
            goto L102
        L97:
            r128 = r411;
            goto L98
        L93:
            r127 = r410;
            goto L94
        L89:
            r126 = r319;
            goto L90
        L85:
            r125 = r318;
            goto L86
        L81:
            r124 = r317;
            goto L82
        L77:
            r123 = r316;
            goto L78
        L73:
            r122 = r315;
            goto L74
        L69:
            r121 = r314;
            goto L70
        L65:
            r120 = r313;
            goto L66
        L61:
            r119 = r312;
            goto L62
        L57:
            r118 = r311;
            goto L58
        L53:
            r117 = r310;
            goto L55
        L49:
            r116 = r219;
            goto L51
        L45:
            r115 = r218;
            goto L47
        L41:
            r114 = r217;
            goto L43
        L37:
            r113 = r216;
            goto L39
        L33:
            r107 = r215;
            goto L35
        L29:
            r106 = r214;
            goto L31
        L25:
            r105 = r213;
            goto L27
        L21:
            r104 = r212;
            goto L23
        L17:
            r103 = r211;
            goto L19
        L13:
            r102 = r210;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final String component1() {
            return this.content;
        }

        public final boolean component10() {
            return this.localIntercepted;
        }

        public final String component11() {
            return this.localInterceptInfo;
        }

        public final boolean component12() {
            return this.textFromAudio;
        }

        public final boolean component13() {
            return this.isReedit;
        }

        public final boolean component14() {
            return this.isInquiryText;
        }

        public final String component15() {
            return this.selectionTextAction;
        }

        public final String component16() {
            return this.lyricCreateType;
        }

        public final List<String> component17() {
            return this.attachmentLocalMsgIds;
        }

        public final String component18() {
            return this.textLocalMsgId;
        }

        public final boolean component19() {
            return this.clearInputContent;
        }

        public final String component2() {
            return this.hint;
        }

        public final String component20() {
            return this.enterMethod;
        }

        public final Map<String, String> component21() {
            return this.messageExt;
        }

        public final SuggestedAction component22() {
            return this.suggestedAction;
        }

        public final String component23() {
            return this.scene;
        }

        public final String component24() {
            return this.txtScene;
        }

        public final String component25() {
            return this.previousPage;
        }

        public final Boolean component26() {
            return this.voiceMixInput;
        }

        public final CustomMultiAttachmentInfo component27() {
            return this.customMultiAttachment;
        }

        public final FlowDriveFileSendInfo component28() {
            return this.driveFileSendInfo;
        }

        public final String component29() {
            return this.creationSendTraceId;
        }

        public final AttachmentInfo component3() {
            return this.attachment;
        }

        public final ChatPageContext component30() {
            return this.chatPageContext;
        }

        public final Map<String, String> component31() {
            return this.fileForceTraceMap;
        }

        public final Map<String, String> component32() {
            return this.textForceTraceMap;
        }

        public final Long component33() {
            return this.sendClickTimestamp;
        }

        public final MultiAttachmentInfo component4() {
            return this.multiAttachment;
        }

        public final ReferenceInfo component5() {
            return this.referenceInfo;
        }

        public final Map<String, String> component6() {
            return this.actionBarInstructionMap;
        }

        public final Boolean component7() {
            return this.isShowFullInputBox;
        }

        public final Boolean component8() {
            return this.isUseFullInputBox;
        }

        public final int component9() {
            return this.actionInstruction;
        }

        public final OnSendParams copy(String r310, String r311, AttachmentInfo r312, MultiAttachmentInfo r410, ReferenceInfo r411, Map<String, String> r412, Boolean r413, Boolean r414, int r415, boolean r416, String r417, boolean r418, boolean r419, boolean r510, String r511, String r512, List<String> r513, String r514, boolean r515, String r516, Map<String, String> r517, SuggestedAction r518, String r519, String r610, String r611, Boolean r612, CustomMultiAttachmentInfo r613, FlowDriveFileSendInfo r614, String r615, ChatPageContext r616, Map<String, String> r617, Map<String, String> r618, Long r619) {
            Intrinsics.checkNotNullParameter(r310, "content");
            Intrinsics.checkNotNullParameter(r311, "hint");
            Intrinsics.checkNotNullParameter(r417, "localInterceptInfo");
            Intrinsics.checkNotNullParameter(r516, "enterMethod");
            return new OnSendParams(r310, r311, r312, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof OnSendParams) == true) goto L8;
            return false;
        L8:
            OnSendParams r101 = (OnSendParams) r100;
            if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.hint, r101.hint) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.attachment, r101.attachment) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.multiAttachment, r101.multiAttachment) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.referenceInfo, r101.referenceInfo) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.actionBarInstructionMap, r101.actionBarInstructionMap) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.isShowFullInputBox, r101.isShowFullInputBox) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.isUseFullInputBox, r101.isUseFullInputBox) == true) goto L33;
            return false;
        L33:
            if (this.actionInstruction == r101.actionInstruction) goto L36;
            return false;
        L36:
            if (this.localIntercepted == r101.localIntercepted) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.localInterceptInfo, r101.localInterceptInfo) == true) goto L42;
            return false;
        L42:
            if (this.textFromAudio == r101.textFromAudio) goto L45;
            return false;
        L45:
            if (this.isReedit == r101.isReedit) goto L48;
            return false;
        L48:
            if (this.isInquiryText == r101.isInquiryText) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.selectionTextAction, r101.selectionTextAction) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.lyricCreateType, r101.lyricCreateType) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.attachmentLocalMsgIds, r101.attachmentLocalMsgIds) == true) goto L60;
            return false;
        L60:
            if (Intrinsics.areEqual(this.textLocalMsgId, r101.textLocalMsgId) == true) goto L63;
            return false;
        L63:
            if (this.clearInputContent == r101.clearInputContent) goto L66;
            return false;
        L66:
            if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L69;
            return false;
        L69:
            if (Intrinsics.areEqual(this.messageExt, r101.messageExt) == true) goto L72;
            return false;
        L72:
            if (Intrinsics.areEqual(this.suggestedAction, r101.suggestedAction) == true) goto L75;
            return false;
        L75:
            if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L78;
            return false;
        L78:
            if (Intrinsics.areEqual(this.txtScene, r101.txtScene) == true) goto L81;
            return false;
        L81:
            if (Intrinsics.areEqual(this.previousPage, r101.previousPage) == true) goto L84;
            return false;
        L84:
            if (Intrinsics.areEqual(this.voiceMixInput, r101.voiceMixInput) == true) goto L87;
            return false;
        L87:
            if (Intrinsics.areEqual(this.customMultiAttachment, r101.customMultiAttachment) == true) goto L90;
            return false;
        L90:
            if (Intrinsics.areEqual(this.driveFileSendInfo, r101.driveFileSendInfo) == true) goto L93;
            return false;
        L93:
            if (Intrinsics.areEqual(this.creationSendTraceId, r101.creationSendTraceId) == true) goto L96;
            return false;
        L96:
            if (Intrinsics.areEqual(this.chatPageContext, r101.chatPageContext) == true) goto L99;
            return false;
        L99:
            if (Intrinsics.areEqual(this.fileForceTraceMap, r101.fileForceTraceMap) == true) goto L102;
            return false;
        L102:
            if (Intrinsics.areEqual(this.textForceTraceMap, r101.textForceTraceMap) == true) goto L105;
            return false;
        L105:
            if (Intrinsics.areEqual(this.sendClickTimestamp, r101.sendClickTimestamp) == true) goto L107;
            return false;
        L107:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.content.hashCode() * 31) + this.hint.hashCode()) * 31;
            AttachmentInfo r101 = this.attachment;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            MultiAttachmentInfo r105 = this.multiAttachment;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            ReferenceInfo r108 = this.referenceInfo;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            Map<String, String> r111 = this.actionBarInstructionMap;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            Boolean r114 = this.isShowFullInputBox;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            Boolean r117 = this.isUseFullInputBox;
            if (r117 != null) goto L25;
            int r118 = 0;
        L26:
            int r119 = (((r116 + r118) * 31) + this.actionInstruction) * 31;
            int r120 = 1231;
            if (this.localIntercepted == false) goto L29;
            int r121 = 1231;
        L30:
            int r122 = (((r119 + r121) * 31) + this.localInterceptInfo.hashCode()) * 31;
            if (this.textFromAudio == false) goto L33;
            int r123 = 1231;
        L34:
            int r124 = (r122 + r123) * 31;
            if (this.isReedit == false) goto L37;
            int r125 = 1231;
        L38:
            int r126 = (r124 + r125) * 31;
            if (this.isInquiryText == false) goto L41;
            int r127 = 1231;
        L42:
            int r128 = (r126 + r127) * 31;
            String r129 = this.selectionTextAction;
            if (r129 != null) goto L45;
            int r130 = 0;
        L46:
            int r131 = (r128 + r130) * 31;
            String r132 = this.lyricCreateType;
            if (r132 != null) goto L49;
            int r133 = 0;
        L50:
            int r134 = (r131 + r133) * 31;
            List<String> r135 = this.attachmentLocalMsgIds;
            if (r135 != null) goto L53;
            int r136 = 0;
        L54:
            int r137 = (r134 + r136) * 31;
            String r138 = this.textLocalMsgId;
            if (r138 != null) goto L57;
            int r139 = 0;
        L58:
            int r140 = (r137 + r139) * 31;
            if (this.clearInputContent == true) goto L62;
            r120 = 1237;
        L62:
            int r141 = (((r140 + r120) * 31) + this.enterMethod.hashCode()) * 31;
            Map<String, String> r142 = this.messageExt;
            if (r142 != null) goto L65;
            int r143 = 0;
        L66:
            int r144 = (r141 + r143) * 31;
            SuggestedAction r145 = this.suggestedAction;
            if (r145 != null) goto L69;
            int r146 = 0;
        L70:
            int r147 = (r144 + r146) * 31;
            String r148 = this.scene;
            if (r148 != null) goto L73;
            int r149 = 0;
        L74:
            int r150 = (r147 + r149) * 31;
            String r151 = this.txtScene;
            if (r151 != null) goto L77;
            int r152 = 0;
        L78:
            int r153 = (r150 + r152) * 31;
            String r154 = this.previousPage;
            if (r154 != null) goto L81;
            int r155 = 0;
        L82:
            int r156 = (r153 + r155) * 31;
            Boolean r157 = this.voiceMixInput;
            if (r157 != null) goto L85;
            int r158 = 0;
        L86:
            int r159 = (r156 + r158) * 31;
            CustomMultiAttachmentInfo r160 = this.customMultiAttachment;
            if (r160 != null) goto L89;
            int r161 = 0;
        L90:
            int r162 = (r159 + r161) * 31;
            FlowDriveFileSendInfo r163 = this.driveFileSendInfo;
            if (r163 != null) goto L93;
            int r164 = 0;
        L94:
            int r165 = (r162 + r164) * 31;
            String r166 = this.creationSendTraceId;
            if (r166 != null) goto L97;
            int r167 = 0;
        L98:
            int r168 = (r165 + r167) * 31;
            ChatPageContext r169 = this.chatPageContext;
            if (r169 != null) goto L101;
            int r170 = 0;
        L102:
            int r171 = (r168 + r170) * 31;
            Map<String, String> r172 = this.fileForceTraceMap;
            if (r172 != null) goto L105;
            int r173 = 0;
        L106:
            int r174 = (r171 + r173) * 31;
            Map<String, String> r175 = this.textForceTraceMap;
            if (r175 != null) goto L109;
            int r176 = 0;
        L110:
            int r177 = (r174 + r176) * 31;
            Long r178 = this.sendClickTimestamp;
            if (r178 == null) goto L115;
            r102 = r178.hashCode();
        L115:
            return r177 + r102;
        L109:
            r176 = r175.hashCode();
            goto L110
        L105:
            r173 = r172.hashCode();
            goto L106
        L101:
            r170 = r169.hashCode();
            goto L102
        L97:
            r167 = r166.hashCode();
            goto L98
        L93:
            r164 = r163.hashCode();
            goto L94
        L89:
            r161 = r160.hashCode();
            goto L90
        L85:
            r158 = r157.hashCode();
            goto L86
        L81:
            r155 = r154.hashCode();
            goto L82
        L77:
            r152 = r151.hashCode();
            goto L78
        L73:
            r149 = r148.hashCode();
            goto L74
        L69:
            r146 = r145.hashCode();
            goto L70
        L65:
            r143 = r142.hashCode();
            goto L66
        L57:
            r139 = r138.hashCode();
            goto L58
        L53:
            r136 = r135.hashCode();
            goto L54
        L49:
            r133 = r132.hashCode();
            goto L50
        L45:
            r130 = r129.hashCode();
            goto L46
        L41:
            r127 = 1237;
            goto L42
        L37:
            r125 = 1237;
            goto L38
        L33:
            r123 = 1237;
            goto L34
        L29:
            r121 = 1237;
            goto L30
        L25:
            r118 = r117.hashCode();
            goto L26
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public String toString() {
            return "OnSendParams(content=" + this.content + ", hint=" + this.hint + ", attachment=" + this.attachment + ", multiAttachment=" + this.multiAttachment + ", referenceInfo=" + this.referenceInfo + ", actionBarInstructionMap=" + this.actionBarInstructionMap + ", isShowFullInputBox=" + this.isShowFullInputBox + ", isUseFullInputBox=" + this.isUseFullInputBox + ", actionInstruction=" + this.actionInstruction + ", localIntercepted=" + this.localIntercepted + ", localInterceptInfo=" + this.localInterceptInfo + ", textFromAudio=" + this.textFromAudio + ", isReedit=" + this.isReedit + ", isInquiryText=" + this.isInquiryText + ", selectionTextAction=" + this.selectionTextAction + ", lyricCreateType=" + this.lyricCreateType + ", attachmentLocalMsgIds=" + this.attachmentLocalMsgIds + ", textLocalMsgId=" + this.textLocalMsgId + ", clearInputContent=" + this.clearInputContent + ", enterMethod=" + this.enterMethod + ", messageExt=" + this.messageExt + ", suggestedAction=" + this.suggestedAction + ", scene=" + this.scene + ", txtScene=" + this.txtScene + ", previousPage=" + this.previousPage + ", voiceMixInput=" + this.voiceMixInput + ", customMultiAttachment=" + this.customMultiAttachment + ", driveFileSendInfo=" + this.driveFileSendInfo + ", creationSendTraceId=" + this.creationSendTraceId + ", chatPageContext=" + this.chatPageContext + ", fileForceTraceMap=" + this.fileForceTraceMap + ", textForceTraceMap=" + this.textForceTraceMap + ", sendClickTimestamp=" + this.sendClickTimestamp + ')';
        }

        public final Map<String, String> getActionBarInstructionMap() {
            return this.actionBarInstructionMap;
        }

        public final int getActionInstruction() {
            return this.actionInstruction;
        }

        public final AttachmentInfo getAttachment() {
            return this.attachment;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getCreationSendTraceId() {
            return this.creationSendTraceId;
        }

        public final CustomMultiAttachmentInfo getCustomMultiAttachment() {
            return this.customMultiAttachment;
        }

        public final FlowDriveFileSendInfo getDriveFileSendInfo() {
            return this.driveFileSendInfo;
        }

        public final String getEnterMethod() {
            return this.enterMethod;
        }

        public final String getHint() {
            return this.hint;
        }

        public final String getLocalInterceptInfo() {
            return this.localInterceptInfo;
        }

        public final boolean getLocalIntercepted() {
            return this.localIntercepted;
        }

        public final String getLyricCreateType() {
            return this.lyricCreateType;
        }

        public final MultiAttachmentInfo getMultiAttachment() {
            return this.multiAttachment;
        }

        public final String getPreviousPage() {
            return this.previousPage;
        }

        public final ReferenceInfo getReferenceInfo() {
            return this.referenceInfo;
        }

        public final String getScene() {
            return this.scene;
        }

        public final String getSelectionTextAction() {
            return this.selectionTextAction;
        }

        public final Long getSendClickTimestamp() {
            return this.sendClickTimestamp;
        }

        public final SuggestedAction getSuggestedAction() {
            return this.suggestedAction;
        }

        public final boolean getTextFromAudio() {
            return this.textFromAudio;
        }

        public final String getTxtScene() {
            return this.txtScene;
        }

        public final Boolean getVoiceMixInput() {
            return this.voiceMixInput;
        }

        public final boolean isInquiryText() {
            return this.isInquiryText;
        }

        public final boolean isReedit() {
            return this.isReedit;
        }

        public final Boolean isShowFullInputBox() {
            return this.isShowFullInputBox;
        }

        public final Boolean isUseFullInputBox() {
            return this.isUseFullInputBox;
        }

        public OnSendParams(String r100, String r101, AttachmentInfo r102, MultiAttachmentInfo r110, ReferenceInfo r111, Map<String, String> r112, Boolean r113, Boolean r114, int r115, boolean r116, String r117, boolean r118, boolean r119, boolean r210, String r211, String r212, List<String> r213, String r214, boolean r215, String r216, Map<String, String> r217, SuggestedAction r218, String r219, String r310, String r311, Boolean r312, CustomMultiAttachmentInfo r313, FlowDriveFileSendInfo r314, String r315, ChatPageContext r316, Map<String, String> r317, Map<String, String> r318, Long r319) {
            Intrinsics.checkNotNullParameter(r100, "content");
            Intrinsics.checkNotNullParameter(r101, "hint");
            Intrinsics.checkNotNullParameter(r117, "localInterceptInfo");
            Intrinsics.checkNotNullParameter(r216, "enterMethod");
            this.content = r100;
            this.hint = r101;
            this.attachment = r102;
            this.multiAttachment = r110;
            this.referenceInfo = r111;
            this.actionBarInstructionMap = r112;
            this.isShowFullInputBox = r113;
            this.isUseFullInputBox = r114;
            this.actionInstruction = r115;
            this.localIntercepted = r116;
            this.localInterceptInfo = r117;
            this.textFromAudio = r118;
            this.isReedit = r119;
            this.isInquiryText = r210;
            this.selectionTextAction = r211;
            this.lyricCreateType = r212;
            this.attachmentLocalMsgIds = r213;
            this.textLocalMsgId = r214;
            this.clearInputContent = r215;
            this.enterMethod = r216;
            this.messageExt = r217;
            this.suggestedAction = r218;
            this.scene = r219;
            this.txtScene = r310;
            this.previousPage = r311;
            this.voiceMixInput = r312;
            this.customMultiAttachment = r313;
            this.driveFileSendInfo = r314;
            this.creationSendTraceId = r315;
            this.chatPageContext = r316;
            this.fileForceTraceMap = r317;
            this.textForceTraceMap = r318;
            this.sendClickTimestamp = r319;
        }

        public /* synthetic */ OnSendParams(String r310, String r311, AttachmentInfo r410, MultiAttachmentInfo r411, ReferenceInfo r412, Map r413, Boolean r414, Boolean r415, int r416, boolean r417, String r418, boolean r419, boolean r510, boolean r511, String r512, String r513, List r514, String r515, boolean r516, String r517, Map r518, SuggestedAction r519, String r610, String r611, String r612, Boolean r613, CustomMultiAttachmentInfo r614, FlowDriveFileSendInfo r615, String r616, ChatPageContext r617, Map r618, Map r619, Long r710, int r711, int r712, DefaultConstructorMarker r713) {
            if ((r711 & 32) == 0) goto L5;
            Map r100 = null;
        L7:
            if ((r711 & 64) == 0) goto L9;
            Boolean r110 = Boolean.FALSE;
        L11:
            if ((r711 & 128) == 0) goto L13;
            Boolean r111 = Boolean.FALSE;
        L15:
            if ((r711 & 512) == 0) goto L17;
            boolean r112 = false;
        L19:
            if ((r711 & 1024) == 0) goto L21;
            String r113 = "";
        L23:
            if ((r711 & 2048) == 0) goto L25;
            boolean r114 = false;
        L27:
            if ((r711 & 4096) == 0) goto L29;
            boolean r115 = false;
        L31:
            if ((r711 & 8192) == 0) goto L33;
            boolean r116 = false;
        L35:
            if ((r711 & 16384) == 0) goto L37;
            String r117 = null;
        L39:
            if ((32768 & r711) == 0) goto L41;
            String r118 = "";
        L43:
            if ((65536 & r711) == 0) goto L45;
            List r210 = null;
        L47:
            if ((131072 & r711) == 0) goto L49;
            String r211 = null;
        L51:
            if ((262144 & r711) == 0) goto L53;
            boolean r212 = true;
        L55:
            if ((524288 & r711) == 0) goto L57;
            String r213 = "";
        L59:
            if ((1048576 & r711) == 0) goto L61;
            Map r214 = null;
        L63:
            if ((2097152 & r711) == 0) goto L65;
            SuggestedAction r215 = null;
        L67:
            if ((4194304 & r711) == 0) goto L69;
            String r216 = null;
        L71:
            if ((8388608 & r711) == 0) goto L73;
            String r217 = null;
        L75:
            if ((16777216 & r711) == 0) goto L77;
            String r218 = null;
        L79:
            if ((33554432 & r711) == 0) goto L81;
            Boolean r219 = null;
        L83:
            if ((67108864 & r711) == 0) goto L85;
            CustomMultiAttachmentInfo r312 = null;
        L87:
            if ((134217728 & r711) == 0) goto L89;
            FlowDriveFileSendInfo r313 = null;
        L91:
            if ((268435456 & r711) == 0) goto L93;
            String r314 = null;
        L95:
            if ((536870912 & r711) == 0) goto L97;
            ChatPageContext r315 = null;
        L99:
            if ((1073741824 & r711) == 0) goto L101;
            Map r316 = null;
        L103:
            if ((r711 & Integer.MIN_VALUE) == 0) goto L105;
            Map r317 = null;
        L107:
            if ((r712 & 1) == 0) goto L109;
            Long r318 = null;
        L110:
            this(r310, r311, r410, r411, r412, r100, r110, r111, r416, r112, r113, r114, r115, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r312, r313, r314, r315, r316, r317, r318);
            return;
        L109:
            r318 = r710;
            goto L110
        L105:
            r317 = r619;
            goto L107
        L101:
            r316 = r618;
            goto L103
        L97:
            r315 = r617;
            goto L99
        L93:
            r314 = r616;
            goto L95
        L89:
            r313 = r615;
            goto L91
        L85:
            r312 = r614;
            goto L87
        L81:
            r219 = r613;
            goto L83
        L77:
            r218 = r612;
            goto L79
        L73:
            r217 = r611;
            goto L75
        L69:
            r216 = r610;
            goto L71
        L65:
            r215 = r519;
            goto L67
        L61:
            r214 = r518;
            goto L63
        L57:
            r213 = r517;
            goto L59
        L53:
            r212 = r516;
            goto L55
        L49:
            r211 = r515;
            goto L51
        L45:
            r210 = r514;
            goto L47
        L41:
            r118 = r513;
            goto L43
        L37:
            r117 = r512;
            goto L39
        L33:
            r116 = r511;
            goto L35
        L29:
            r115 = r510;
            goto L31
        L25:
            r114 = r419;
            goto L27
        L21:
            r113 = r418;
            goto L23
        L17:
            r112 = r417;
            goto L19
        L13:
            r111 = r415;
            goto L15
        L9:
            r110 = r414;
            goto L11
        L5:
            r100 = r413;
            goto L7
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003HÆ\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fR\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$SendMessageTrackExtMap;", "Landroid/os/Parcelable;", "extMap", "", "", "<init>", "(Ljava/util/Map;)V", "getExtMap", "()Ljava/util/Map;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SendMessageTrackExtMap implements Parcelable {
        public static final Parcelable.Creator<SendMessageTrackExtMap> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f298404a;

        public static final class a implements Parcelable.Creator<SendMessageTrackExtMap> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SendMessageTrackExtMap createFromParcel(Parcel r100) {
                Intrinsics.checkNotNullParameter(r100, "parcel");
                int r101 = r100.readInt();
                LinkedHashMap r102 = new LinkedHashMap(r101);
                int r103 = 0;
            L3:
                if (r103 == r101) goto L6;
                r102.put(r100.readString(), r100.readString());
                r103 = r103 + 1;
                goto L3
            L6:
                return new SendMessageTrackExtMap(r102);
            }

            @Override // android.os.Parcelable.Creator
            public final SendMessageTrackExtMap[] newArray(int r100) {
                return new SendMessageTrackExtMap[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public SendMessageTrackExtMap() {
            this(0);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof SendMessageTrackExtMap) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f298404a, ((SendMessageTrackExtMap) r100).f298404a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f298404a.hashCode();
        }

        public final String toString() {
            return "SendMessageTrackExtMap(extMap=" + this.f298404a + ')';
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dest");
            Map<String, String> r102 = this.f298404a;
            r100.writeInt(r102.size());
            Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            Map.Entry<String, String> r104 = r103.next();
            r100.writeString(r104.getKey());
            r100.writeString(r104.getValue());
            goto L4
        }

        public SendMessageTrackExtMap(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "extMap");
            this.f298404a = r100;
        }

        public /* synthetic */ SendMessageTrackExtMap(int r100) {
            this(MapsKt.emptyMap());
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f298405a = null;

        static {
            f298405a = new a();
        }

        public a() {
        }
    }

    public static final class b {
        public static /* synthetic */ boolean b(ICoreInputAbility r100) {
            r100.qp(false);
            return true;
        }

        public static /* synthetic */ void a(ICoreInputAbility r100, int r101) {
            boolean r102 = true;
            if ((r101 & 1) == 0) goto L5;
            boolean r103 = true;
        L7:
            if ((r101 & 2) != 0) goto L10;
            r102 = false;
        L10:
            r100.WM(r103, r102);
            return;
        L5:
            r103 = false;
            goto L7
        }

        public static /* synthetic */ void e(ICoreInputAbility r100, String r101, com.larus.uaigc.music.applet.a1 r102, boolean r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r104 & 4) == 0) goto L8;
            r103 = true;
        L8:
            r100.Kh(r101, r102, r103);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(ICoreInputAbility r100, String r101, boolean r110, SuggestedAction r111, String r112, Map r113, int r114) {
            if ((r114 & 4) == 0) goto L5;
            SuggestedAction r102 = null;
        L7:
            if ((r114 & 8) == 0) goto L9;
            String r103 = null;
        L11:
            if ((r114 & 16) == 0) goto L13;
            Map r104 = null;
        L14:
            r100.SK(r101, r110, r102, r103, r104);
            return;
        L13:
            r104 = r113;
            goto L14
        L9:
            r103 = r112;
            goto L11
        L5:
            r102 = r111;
            goto L7
        }

        public static /* synthetic */ void d(ICoreInputAbility r100, CharSequence r110, boolean r111, boolean r112, Integer r113, Integer r114, boolean r115, int r116) {
            if ((r116 & 2) == 0) goto L5;
            boolean r101 = true;
        L7:
            if ((r116 & 4) == 0) goto L9;
            boolean r102 = false;
        L11:
            if ((r116 & 8) == 0) goto L13;
            Integer r103 = null;
        L15:
            if ((r116 & 16) == 0) goto L17;
            Integer r104 = null;
        L19:
            if ((r116 & 32) == 0) goto L21;
            boolean r105 = true;
        L22:
            r100.M50(r110, r101, r102, r103, r104, r105);
            return;
        L21:
            r105 = r115;
            goto L22
        L17:
            r104 = r114;
            goto L19
        L13:
            r103 = r113;
            goto L15
        L9:
            r102 = r112;
            goto L11
        L5:
            r101 = r111;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public interface c {
        String a(String r100);

        String b(String r100);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public interface d {
        void a();

        void b(OnSendParams r100);

        void c();
    }

    /* JADX INFO: loaded from: classes4.dex */
    public interface e {
        void h(String r100);

        void i(String r100);

        void j(String r100);
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f298406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f298407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f298408c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f298406a, r101.f298406a) == true) goto L12;
            return false;
        L12:
            if (this.f298407b == r101.f298407b) goto L15;
            return false;
        L15:
            if (this.f298408c == r101.f298408c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f298406a.hashCode() * 31;
            int r101 = 1231;
            if (this.f298407b == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f298408c == true) goto L11;
            r101 = 1237;
        L11:
            return r103 + r101;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "MentionConfig(appId=" + this.f298406a + ", isUserCountVisible=" + this.f298407b + ", isInterruptAtAll=" + this.f298408c + ')';
        }

        public f(String r100) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            this.f298406a = r100;
            this.f298407b = false;
            this.f298408c = true;
        }
    }

    static {
        A1 = a.f298405a;
    }

    void BU(boolean r100, boolean r101, String r102);

    void Ba();

    boolean Bd();

    void C1(boolean r100, boolean r101, String r102);

    boolean CD(boolean r100);

    boolean CS();

    void Dh(Function1<? super Boolean, Unit> r100);

    void Dn(f r100);

    void Dr(boolean r100);

    void E0(OnSendParams r100);

    boolean E50();

    boolean EK();

    String EW();

    void F5(nr9.g r100, String r101, Map<String, String> r102, Map<String, String> r103);

    MessageModifyMode FF();

    void Fz(c r100);

    void I40();

    boolean J8();

    void JJ(wc9.e r100);

    CoreInputAbility JO();

    void Jc(Context r100);

    z8.a Jd();

    void Jm(d r100);

    void Kh(String r100, Function0<Unit> r101, boolean r102);

    com.larus.bmhome.chat.component.bottom.multimodal.sender.f Lk();

    void M5(CharSequence r100);

    void M50(CharSequence r100, boolean r101, boolean r102, Integer r103, Integer r104, boolean r105);

    String N5();

    void PZ(wc9.e r100);

    boolean Pi();

    boolean Q2();

    void Q8(String r100);

    void QG(e r100);

    boolean Qd(boolean r100);

    void Rk();

    int Rp();

    boolean SE(String r100);

    void SK(String r100, boolean r101, SuggestedAction r102, String r103, Map<String, String> r104);

    void SV(Integer r100);

    void Uu(String r100, boolean r101);

    void V40();

    void Vs(e r100);

    void WM(boolean r100, boolean r101);

    void Wy(String r100, long r101, Boolean r102);

    boolean Wz();

    void XG(d r100);

    void YT(e r100);

    void Yk(CharSequence r100);

    void aR(String r100);

    boolean b9();

    void bu(String r100, SuggestedAction r101, String r102, Map r103, Map r104, Map r105);

    boolean c1();

    boolean c2();

    void cp();

    boolean d9();

    void eQ(EditPos r100, BotModel r101);

    void eo();

    void f40(SkillComponent.l r100);

    boolean fa(be8.b r100);

    void g2(int r100, boolean r101);

    void gX(boolean r100);

    boolean gj();

    void iN(Function0<Boolean> r100);

    void jm(wq8.b r100, Message r101, boolean r102, MessageModifyMode r103);

    CoreInputAbility kO(z8.a r100);

    boolean l6();

    boolean lF();

    boolean lW(BotModel r100, String r101);

    void m1(ViewGroup r100);

    boolean m2(String r100);

    boolean m9();

    void mv(String r100, boolean r101);

    void o40();

    void oz(boolean r100);

    void p80(boolean r100);

    void pS(Function0<Boolean> r100);

    g9.c q20();

    void qB(CharSequence r100, boolean r101, boolean r102, boolean r103);

    void qp(boolean r100);

    void r7(Function1<? super Boolean, Unit> r100);

    void rE();

    void s20(int r100);

    void s3(long r100);

    void sQ(com.larus.bmhome.chat.component.title.f0 r100);

    void setEnabled(boolean r100);

    com.larus.bmhome.chat.model.b0 tO();

    void tr(Function1<? super OnSendParams, Boolean> r100);

    void tw(String r100, boolean r101);

    void uG();

    void uU(com.larus.bmhome.chat.component.list.h1 r100, com.larus.bmhome.chat.component.list.i1 r101);

    void uh(int r100);

    void uq(boolean r100);

    void uw(Function1<? super Boolean, Unit> r100);

    void v6(Function2<? super Integer, ? super Long, Unit> r100);

    CharSequence ws(Context r100, String r101);

    boolean wy();

    void zM();

    void zi();

    void zk(String r100);
}
