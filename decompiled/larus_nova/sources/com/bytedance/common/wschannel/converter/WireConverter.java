package com.bytedance.common.wschannel.converter;

import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.bytedance.common.wschannel.model.Frame;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
class WireConverter implements MsgConverter {
    public WireConverter() {
    }

    private static String appendServerTiming(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        StringBuilder r101 = new StringBuilder(r100);
        int r102 = r101.indexOf("ttnet;");
        if (r102 >= 0) goto L8;
        return null;
    L8:
        r101.insert(r102 + 6, "recv_time=" + System.currentTimeMillis() + i.f25853b);
        return r101.toString();
    }

    @Override // com.bytedance.common.wschannel.converter.MsgConverter
    public WsChannelMsg decode(byte[] r110) throws IOException {
        Frame r111 = Frame.ADAPTER.decode(r110);
        long r100 = ((Long) Wire.get(r111.seqid, Frame.DEFAULT_SEQID)).longValue();
        long r101 = ((Long) Wire.get(r111.logid, Frame.DEFAULT_LOGID)).longValue();
        int r102 = ((Integer) Wire.get(r111.service, Frame.DEFAULT_SERVICE)).intValue();
        int r103 = ((Integer) Wire.get(r111.method, Frame.DEFAULT_METHOD)).intValue();
        List r104 = (List) Wire.get(r111.headers, Collections.emptyList());
        String r105 = (String) Wire.get(r111.payload_encoding, "");
        String r106 = (String) Wire.get(r111.payload_type, "");
        byte[] r112 = ((ByteString) Wire.get(r111.payload, Frame.DEFAULT_PAYLOAD)).toByteArray();
        String r113 = (String) Wire.get(r111.serverTiming, "");
        String r114 = (String) Wire.get(r111.msgId, "");
        WsChannelMsg r115 = new WsChannelMsg();
        r115.setLogId(r101);
        r115.setSeqId(r100);
        r115.setService(r102);
        r115.setMethod(r103);
        if (r104 != null) goto L5;
    L11:
        r115.setPayloadEncoding(r105);
        r115.setPayloadType(r106);
        r115.setPayload(r112);
        String r107 = appendServerTiming(r113);
        if (TextUtils.isEmpty(r107) == true) goto L14;
        r113 = r107;
    L14:
        r115.setServerTiming(r113);
        r115.setMsgId(r114);
        return r115;
    L5:
        if (r104.size() < 0) goto L11;
        ArrayList r108 = new ArrayList();
        Iterator r109 = r104.iterator();
    L8:
        if (r109.hasNext() == false) goto L10;
        Frame.ExtendedEntry r116 = (Frame.ExtendedEntry) r109.next();
        WsChannelMsg.MsgHeader r117 = new WsChannelMsg.MsgHeader();
        r117.setKey((String) Wire.get(r116.key, ""));
        r117.setValue((String) Wire.get(r116.value, ""));
        r108.add(r117);
        goto L8
    L10:
        r115.setMsgHeaders(r108);
        goto L11
    }

    @Override // com.bytedance.common.wschannel.converter.MsgConverter
    public byte[] encode(WsChannelMsg r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.getPayload() == null) goto L8;
        ByteString r101 = ByteString.of(r100.getPayload());
    L9:
        Frame.Builder r102 = new Frame.Builder().logid(Long.valueOf(r100.getLogId())).seqid(Long.valueOf(r100.getSeqId())).service(Integer.valueOf(r100.getService())).payload_encoding(r100.getPayloadEncoding()).payload_type(r100.getPayloadType()).payload(r101).method(Integer.valueOf(r100.getMethod()));
        List<WsChannelMsg.MsgHeader> r103 = r100.getMsgHeaders();
        ArrayList r104 = new ArrayList();
        if (r103 == null) goto L16;
        Iterator<WsChannelMsg.MsgHeader> r105 = r103.iterator();
    L13:
        if (r105.hasNext() == false) goto L16;
        WsChannelMsg.MsgHeader r106 = r105.next();
        r104.add(new Frame.ExtendedEntry.Builder().key(r106.getKey()).value(r106.getValue()).build());
    L16:
        if (r104.isEmpty() == true) goto L19;
        r102.headers(r104);
    L19:
        return Frame.ADAPTER.encode(r102.build());
    L8:
        r101 = ByteString.EMPTY;
        goto L9
    }
}
