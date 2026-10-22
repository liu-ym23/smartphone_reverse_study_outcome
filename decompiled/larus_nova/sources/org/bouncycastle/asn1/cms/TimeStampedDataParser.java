package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetStringParser;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.DERIA5String;

/* JADX INFO: loaded from: classes42.dex */
public class TimeStampedDataParser {
    private ASN1OctetStringParser content;
    private DERIA5String dataUri;
    private MetaData metaData;
    private ASN1SequenceParser parser;
    private Evidence temporalEvidence;
    private ASN1Integer version;

    private TimeStampedDataParser(ASN1SequenceParser r100) throws IOException {
        this.parser = r100;
        this.version = ASN1Integer.getInstance(r100.readObject());
        ASN1Encodable r101 = r100.readObject();
        if ((r101 instanceof DERIA5String) == false) goto L6;
        this.dataUri = DERIA5String.getInstance(r101);
        r101 = r100.readObject();
    L6:
        if ((r101 instanceof MetaData) == false) goto L8;
    L9:
        this.metaData = MetaData.getInstance(r101.toASN1Primitive());
        r101 = r100.readObject();
    L11:
        if ((r101 instanceof ASN1OctetStringParser) == false) goto L14;
        this.content = (ASN1OctetStringParser) r101;
        return;
    L14:
        return;
    L8:
        if ((r101 instanceof ASN1SequenceParser) == false) goto L11;
        goto L9
    }

    public static TimeStampedDataParser getInstance(Object r100) throws IOException {
        if ((r100 instanceof ASN1Sequence) == false) goto L7;
        return new TimeStampedDataParser(((ASN1Sequence) r100).parser());
    L7:
        if ((r100 instanceof ASN1SequenceParser) == true) goto L9;
        return null;
    L9:
        return new TimeStampedDataParser((ASN1SequenceParser) r100);
    }

    public ASN1OctetStringParser getContent() {
        return this.content;
    }

    public DERIA5String getDataUri() {
        return this.dataUri;
    }

    public MetaData getMetaData() {
        return this.metaData;
    }

    public Evidence getTemporalEvidence() throws IOException {
        if (this.temporalEvidence != null) goto L6;
        this.temporalEvidence = Evidence.getInstance(this.parser.readObject().toASN1Primitive());
    L6:
        return this.temporalEvidence;
    }

    public int getVersion() {
        return this.version.getValue().intValue();
    }
}
