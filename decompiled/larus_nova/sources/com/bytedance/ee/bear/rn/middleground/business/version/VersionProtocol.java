package com.bytedance.ee.bear.rn.middleground.business.version;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.document.comment.bean.CommentJsRequestBean;
import com.bytedance.ee.bear.rn.middleground.protocol.Protocol;
import com.bytedance.ee.bear.rn.middleground.protocol.Protocol.Body;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0002\u0006\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/version/VersionProtocol;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "<init>", "()V", "BeginSync", "EndSync", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class VersionProtocol<T extends Protocol.Body> extends Protocol<T> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/version/VersionProtocol$BeginSync;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body$Empty;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BeginSync extends Protocol<Protocol.Body.Empty> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            Protocol.Entity.Identifier r100 = getMIdentifier();
            Intrinsics.checkNotNull(r100);
            int r110 = r100.getType();
            Protocol.Entity.Identifier r101 = getMIdentifier();
            Intrinsics.checkNotNull(r101);
            return JSON.toJSONString(new Protocol.Entity.Base("version", new Protocol.Entity.Data(CommentJsRequestBean.ACTION_BEGIN_SNYC, null, new Protocol.Entity.Identifier(r110, r101.getToken(), false, null, 12, null), null, null, 26, null)), true);
        }

        public BeginSync() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/rn/middleground/business/version/VersionProtocol$EndSync;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol;", "Lcom/bytedance/ee/bear/rn/middleground/protocol/Protocol$Body$Empty;", "<init>", "()V", "getJsonString", "", "features-rn-bridge-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EndSync extends Protocol<Protocol.Body.Empty> {
        @Override // com.bytedance.ee.bear.rn.middleground.protocol.Protocol
        public String getJsonString() {
            Protocol.Entity.Identifier r100 = getMIdentifier();
            Intrinsics.checkNotNull(r100);
            int r110 = r100.getType();
            Protocol.Entity.Identifier r101 = getMIdentifier();
            Intrinsics.checkNotNull(r101);
            return JSON.toJSONString(new Protocol.Entity.Base("version", new Protocol.Entity.Data(CommentJsRequestBean.ACTION_END_SYNC, null, new Protocol.Entity.Identifier(r110, r101.getToken(), false, null, 12, null), null, null, 26, null)), true);
        }

        public EndSync() {
        }
    }

    public VersionProtocol() {
    }
}
